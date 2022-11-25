package eva3_2_comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author moviles
 * Friday October 25 2022
 */

/*
    Comparator
*/
public class EVA3_2_COMPARATOR {

    public static void main(String[] args) {
        LinkedList <Integer> myList = new <Integer> LinkedList();
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        
        System.out.println(myList);
        
        // Si se quiere ordenar, debe haber un criterio.
        // Para ordenar, debemos utilizar un comparador.
        
        // Comparator es una interfaz.        
        Comparator ordenar = new Comparator() { // Clase anónima: Clase que no tiene que ser instanciada.

            @Override
            public int compare(Object o1, Object o2) {
                Integer val1 = (Integer)o1;
                Integer val2 = (Integer)o2;
                
                return val1 - val2;
            }
        };
        
        // Mandamos el comparator recién creado arriba
        myList.sort(ordenar);
        
        // Imprimimos la lista
        System.out.println(myList);
        
        
        // Lista que va a almacenar personas
        LinkedList <Person> personList = new <Person> LinkedList();
        personList.add(new Person ("Juan", "Pérez", "Rojas", 14, 0));
        personList.add(new Person ("Pedro", "Corral", "Rivas", 14, 475.50));
        personList.add(new Person ("Carlos", "Rojas", "Cruz", 14, 650));
        personList.add(new Person ("Daniel", "Morales", "Pérez", 21, 1050));
        personList.add(new Person ("Kevin", "González", "Peinado", 18, 350));
        
        // Comparar apellido paterno.
        // Comparar salario.
        
        // Como recorrer collections
        // iterator              
        for (Iterator <Person> iterador = personList.iterator();
            iterador.hasNext();) {
            // Person person = iterador();
        }
        
        /*
        Comparator cadenas = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String)o1;
                String str2 = (String)o2;
                
                return str1 - str2;
            }
        };
        
        personList.sort(cadenas);
        
        System.out.println(personList); */
    }    
}

class Person {
    private String nombre, paterno, materno;
    private int edad;
    private double salario;    

    public Person(String nombre, String paterno, String materno, int edad, double salario) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.salario = salario;
    }
    
    
}