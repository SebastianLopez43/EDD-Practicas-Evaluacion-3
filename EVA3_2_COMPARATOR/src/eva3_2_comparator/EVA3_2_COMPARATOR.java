package eva3_2_comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author José Sebastian López Ibarra
 * Friday October 25 2022
 */

/*
    Comparator
*/

public class EVA3_2_COMPARATOR {

    public static void main(String[] args) {
        
        // Lista
        LinkedList <Integer> myList = new <Integer> LinkedList();        
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        myList.add((int)(Math.random() * 100));
        
        System.out.println("Lista: ");
        System.out.println(myList);
        
        // Si se quiere ordenar, debe haber un criterio.
        // Para ordenar, debemos utilizar un comparador.
        
        // Ordenar -> Comparator
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
        System.out.println("\nLista ordenada: ");
        System.out.println(myList);
        System.out.println();
        
        
        // Lista que va a almacenar personas
        LinkedList <Person> personList = new <Person> LinkedList();
        personList.add(new Person ("Juan", "Pérez", "Rojas", 14, 700));
        personList.add(new Person ("Pedro", "Corral", "Rivas", 14, 475.50));
        personList.add(new Person ("Carlos", "Rojas", "Cruz", 14, 650));
        personList.add(new Person ("Daniel", "Morales", "Pérez", 21, 1050));
        personList.add(new Person ("Kevin", "González", "Peinado", 18, 350));
        
        System.out.println(personList);
        
        // Comparar apellido paterno.                              
        Comparator pLastName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String val1 = o1.toString();
                String val2 = o2.toString();
                
                return val1.compareTo(val2);
            }
        };
        
        personList.sort(pLastName);        
        System.out.println(personList);
        
        // Comparar apellido materno.                              
        Comparator mLastName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String val1 = o1.toString();
                String val2 = o2.toString();
                
                return val1.compareTo(val2);
            }
        };
        
        personList.sort(mLastName);        
        System.out.println(personList);
        
        // Como recorrer collections
        // iterator              
        for (Iterator <Person> iterator = personList.iterator();
            iterator.hasNext();) {
            // Person person = iterador();
        }
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
