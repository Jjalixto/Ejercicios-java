package src;

import src.model.Person;
import src.model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Person p1 = new Person(1,"juan", LocalDate.of(2010,1,1));
        Person p2 = new Person(2,"Ale", LocalDate.of(1980,1,1));
        Person p3 = new Person(3,"Joel", LocalDate.of(1975,1,1));
        Person p4 = new Person(4,"ethan", LocalDate.of(1987,1,1));
        Person p5 = new Person(5,"mario", LocalDate.of(1984,1,1));

        Product pr1 = new Product(1,"ceviche",25.0);
        Product pr2 = new Product(2,"arroz con pollo",15.0);
        Product pr3 = new Product(3,"papa rellena",19.0);
        Product pr4 = new Product(4,"torta",115.0);
        Product pr5 = new Product(5,"torta",85.0);

        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4,pr5);

        //programacion imperativa || programacion funcional
//        for(int i = 0; i < people.size(); i++){
//            System.out.println(people.get(i));
//        }
//        System.out.println(people.size());

//        for(Person p : people ){
//            System.out.println(p);
//        }

        //programacion funcional java 8 pero a traves de funciones es un paradigma

        //parametro de la iteracion | que haras con el parametro osea la condicion
        //people.forEach( p -> System.out.println(p));
        //cuando el parametro de la izquierda es igual al que la derecha entonces puedes imprimirlo defrente
        //     people.forEach(System.out::println);


        //1- filter( param : predicate -> tiene que retornar un true o false)
        //el stream es un metodo para trabajar con colecciones
        List<Person> filteredList =  people.stream()
                .filter(p-> App.getAge(p.getBirthDate()) >= 18)
                .collect(Collectors.toList()); //esto recolecta los datos y forma una lista
//        App.printList(filteredList);



        //2- map (param : function -> retorna algun valor que hayas indicado producto de la funcion echa)
//        basicamente esto es para reutilizar codigo
        Function<String, String> coderFunction = name -> "Coder " + name;
        List<String> filtered2 = people.stream()
                //.filter(p -> App.getAge(p.getBirthDate()) >= 18)
                //.map(p -> App.getAge(p.getBirthDate()))//solo recolecta las edades osea numeros no persoas
                //.map(p -> p.getName())
                .map(Person::getName)
                .map(coderFunction)
                .collect(Collectors.toList()); //entonces con esto me va retornar una coleccion de enteros no de personas
        //primero recolecto sobre el ultimo operar que es map que me ayuda transformar elementos
        //System.out.println(filtered2);

        //3-sorted ( param: Comparator) es mas sencillo si fuera una lista de enteros o string pero tenemos objetos
        Comparator<Person> byNameDesc = (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person> byNameAsc = (Person o1, Person o2) -> o2.getName().compareTo(o1.getName());
        List<Person> filteredList3 = people.stream()
                .sorted(byNameAsc)
                .collect(Collectors.toList());

//        System.out.println(filteredList3);

        //4-Match (param : Predicate)
        //anymatch : no evalua todo el stream , termina en la coincidencia
//        para reutilizar el codigo igual de la funcion anterior uno mismo crea el predicate
//        asi se puede suplantar
//        Predicate<Person> startWithPredicate = person -> person.getName().startsWith("J");
//        boolean rpta1 = people.stream()
//                .anyMatch(startWithPredicate);
        boolean rpta1 = people.stream()
                .anyMatch(p -> p.getName().startsWith("J"));
//        System.out.println(rpta1);

        //allMatch : evalua todo el stream bajo la condicion es decir si tengo un objeto en donde no todos empiecen
//        con J entonces devuelve un false
        boolean rpta2 = people.stream()
                .allMatch(p -> p.getName().startsWith("J"));
//        System.out.println(rpta2);

        //noneMatch : evalua todo el stream bajo la condicion es cuando ninguno coincida con la J
        boolean rpta3 = people.stream()
                .noneMatch(p -> p.getName().startsWith("J"));
//        System.out.println(rpta3);

        //5- Limit / skip esto maoyormente es para la paginacion
        int pageNumber = 2;
        int pageSize = 2;
        List<Person> filteredList4 = people.stream()
                .skip(pageNumber * pageSize) //los 2 primeros los obvia y te duvuelve el resto
                .limit(pageSize) //te da los primeros
                .collect(Collectors.toList());
//        App.printList(filteredList4);

        //6-collectors
        //GroupBy
        Map<String, List<Product>> collect1 = products.stream()
                .filter(p -> p.getPrice() > 20)
                .collect(Collectors.groupingBy(Product::getName));
//        System.out.println(collect1);

        //Counting
        Map<String,Long> collect2 = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getName, Collectors.counting()
                    )
                );
//        System.out.println(collect2);

        //Agrupando por nombre producto y sumando
        Map<String,Double> collect3 = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summingDouble(Product::getPrice)));

//        System.out.println(collect3);
        //obteniendo suma y resumen
        DoubleSummaryStatistics statistics = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
//        System.out.println(statistics);

        //7-reduce
        Optional<Double> reducir = products.stream()
                .map(p -> p.getPrice())
                .reduce(Double::sum);
//        System.out.println(reducir.get());

        //recuerda que las interfaces funcionales son Comparator, Supplier, Predicate, Function

        List<Person> filterMayor = people.stream()
                .filter(p -> App.getAge(p.getBirthDate()) > 40)
                .collect(Collectors.toList());
//        System.out.println(filterMayor);

        List<String> listName = people.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());
//        System.out.println(listName);

        Comparator<Person> comparador = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());
        List<Person> listAsc = people.stream()
                .sorted(comparador)
                .collect(Collectors.toList());
//        System.out.println(listAsc);

        Long mayores = people.stream()
                .filter(p -> App.getAge(p.getBirthDate()) < 30)
                        .collect(Collectors.counting());

//        System.out.println(mayores);

        Optional<Person> buscando = people.stream()
                .filter(p -> p.getName().startsWith("Ale"))
                .findFirst();
//        System.out.println(buscando);

        Comparator<Person> menorEdad = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());
        Optional<String> menor =  people.stream()
                        .min(Comparator.comparingInt(p -> App.getAge(p.getBirthDate())))
                        .map(p -> p.getName());
//        System.out.println(menor.get());

        Map<Character, List<Person>> index = people.stream()
                .collect(Collectors.groupingBy(p -> Character.toUpperCase(p.getName().charAt(0))));
        System.out.println(index);

    }





    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }
}