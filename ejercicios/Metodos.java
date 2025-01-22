package ejercicios;
import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public void printTo255(int n)
    {   
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    public void printToImpar(int n)
    {
        for(int i =0; i <= n;i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }

    public void printIntsAndSum0To255(int n)
    {   
        int sum = 0;
        for(int i = 0; i <= n;i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    
    public void printArrayVals(int[] arr)
    {   
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public void printMaxOfArray(int[] arr)
    {   
        int max = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public void printMinOfArray(int[] arr)
    {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public void printAverageOfArray(int[] arr)
    {   
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = arr[i] + sum;
        }
        System.out.println(sum/2);
    }

    public void squareArrayVals(int[] arr)
    {
        List<Integer> cuadrado = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            cuadrado.add(arr[i]*arr[i]);
        }
        System.out.println(cuadrado);
    }

    public void printArrayCountGreaterThanY(int[] arr,int y)
    {   
        List<Integer> mayores = new ArrayList<>();
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > y){
                mayores.add(arr[i]);
                // System.out.println(arr[i]);
            }
        }
        System.out.println(mayores);
    }

    public void zeroOutArrayNegativeVals(int[] arr)
    {   
        List<Integer> negativosCero = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]<0){
                arr[i] = 0;
                negativosCero.add(arr[i]);
            }else{
                negativosCero.add(arr[i]);
            }
        }
        System.out.println(negativosCero);
    }

    public void printMaxMinAverageArrayVals(int[] arr)
    {   
        int max = arr[0];
        int min = arr[0];
        int promedio = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
            promedio += arr[i];
        }
        System.out.println("Maximo valor " + max + " Minimo valor"+ min + " Promedio" + promedio/2);
    }

    public int[] shiftArrayValsLeft(int[] arr)
    {
        for(int i = 0; i < arr.length -1; i++){
            arr[i] = arr[i+1];
        }

        if(arr.length >0){
            arr[arr.length -1] = 0;
        }
        // System.out.println(arr);
        return arr;
    }

    public void swapStringForArrayNegativeVals(int[] arr)
    {   
        List<Object> negativos = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                negativos.add("Dojo");
            }else{
                negativos.add(arr[i]);
            }

        }
        System.out.println(negativos);
    }

    public void reverseArray(int[] arr)
    { 
        List<Integer> reser = new ArrayList<>();
        
        for(int i = arr.length -1; i >= 0; i--){
            reser.add(arr[i]);
        }
        System.out.println(reser);
    }
    
    public void findValue(int[] arr, int value)
    {
        for(int n : arr){
            if(n == value){
                System.out.println("existe");
            }
        }
        System.out.println("no existe");
    }

    public void countEvenNumbers(int[] arr)
    {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 == 0){
                count += 1;
            }
        }
        System.out.println(count);
    }

    public void findSecondLargest(int[] arr)
    {   
        int max1 = 0;
        int max2 = 0;

        // {17,15,16};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max1){
                max2 = max1; //max2 = 0; primera vuelta 
                max1 = arr[i]; //max1 = 17; primera vuelta
            } else if(arr[i] > max2 && arr[i] < max1){
                max2 = arr[i]; // max2 = 15; segunda vuelta  //max2 = 16; tercerca vuelta
            }
        }
        System.out.println(max2);
    }

    public void multiplyAll(int[] arr, int num){
        
        List<Integer> multiplicacion = new ArrayList<>();
        for(int arreglo : arr){
            multiplicacion.add(arreglo * 2);
        }
        System.out.println(multiplicacion);
    }

    public void reverseString(String cadena)
    {   
        char[] caracteres = cadena.toCharArray();

        List<Character> unirCadena = new ArrayList<>();
        
        for(char c : caracteres){
            unirCadena.add(c);
        }

        // for(int i = 0; i < unirCadena; i++){

        // }
        
        System.out.println(unirCadena);
    }

    // public void mergeAndSort(int[] arr1,int[] arr2)
    // {
    //     List<Integer> merge = new ArrayList<>();
        
    //     //bucle clave valor 
    //     for(int arr : arr1){
    //         merge.add(arr);
    //     }

    //     for(int arr : arr2){
    //         merge.add(arr);
    //     }

    //     System.out.println(merge);
    // }
}
