package src;

import src.model.Person;
import src.model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        Person p1 = new Person(1,"juan", LocalDate.of(2010,1,1));
        Person p2 = new Person(2,"Ale", LocalDate.of(1980,1,1));
        Person p3 = new Person(3,"Joel", LocalDate.of(1975,1,1));
        Person p4 = new Person(4,"ethan", LocalDate.of(1987,1,1));
        Person p5 = new Person(5,"mario", LocalDate.of(1984,1,1));

        Product pr1 = new Product(1,"ceviche",15.0);
        Product pr2 = new Product(2,"arroz con pollo",15.0);
        Product pr3 = new Product(3,"papa rellena",15.0);
        Product pr4 = new Product(4,"torta",15.0);

        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);

        //programacion imperativa
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


        //1- filter( param : predicate)
        //el stream es un metodo para trabajar con colecciones
        List<Person> filteredList =  people.stream()
                .filter(p-> App.getAge(p.getBirthDate()) >= 18)
                .collect(Collectors.toList()); //esto recolecta los datos y forma una lista
        App.printList(filteredList);

        //2- map (param : function)
        List<Integer> filtered2 = people.stream()
                .map(p -> App.getAge(p.getBirthDate()))//solo recolecta numeros
                .collect(Collectors.toList());
        //me ayuda transformar elementos
    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }
}