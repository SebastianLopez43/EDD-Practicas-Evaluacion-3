package eva3_3_busqueda_binaria;

import java.util.Scanner;

/**
 * @author José Sebastian López Ibarra
 */

public class EVA3_3_BUSQUEDA_BINARIA {

    public static void main(String[] args) {
        int[] arregloDatos = new int[15];
        int[] arregloSel = new int[arregloDatos.length];
        
        System.out.println("Arreglo original: ");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        
        System.out.println("Selection Sort");
        copiar(arregloDatos, arregloSel);
        imprimir(arregloSel);
        selectionSort(arregloSel);
        imprimir(arregloSel);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el valor a buscar: ");
        int buscar = sc.nextInt();
        System.out.println("");
        System.out.println("El valor está en la posición: " + busquedaBinaria(arregloSel, buscar));
    }
    //LLENAR ARREGLO
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }
    //IMPRIMIR ARREGLO
    public static void imprimir(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] < 10)
            System.out.print("[" + arreglo[i] + "]");
            else
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    //COPIAR ARREGLO
    public static void copiar(int[] arreglo, int[] copia){
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }
    
    //SELECTION SORT O[n^2]
    //+ Comparaciones
    //- Intercambios (Swap)
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            //Busco el elemento (posición) más pequeño
            for (int j = i+1; j < arreglo.length; j++) {
             //Buscar el más pequeño
             if(arreglo[min] > arreglo[j])
                 min = j;
            }
            //Swap - Intercambiar
            if(min != i){
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }
        }
    }
    
    //Búsqueda binaria -> Arreglo con los datos, valor a buscar
    public static int busquedaBinaria(int[] datos, int valor){
        return busquedaBinRec(datos,0,datos.length-1, valor);
    }
    //O(logn) base 2
    private static int busquedaBinRec(int[] datos, int ini, int fin, int valor){
        int mid = ini + ((fin-ini)/2);
        int resu = -1;
        if(ini < fin){ //Hacemos la búsqueda recursiva
            if(valor == datos[mid])//Lo encontramos
                resu = mid; //Posición donde está el elemento que buscamos
            else if(valor < datos[mid]) //Menor que la mitad, está a la izq.
                resu = busquedaBinRec(datos, ini, mid-1, valor);
            else //Mayor que la mitad, está a la der.
                resu = busquedaBinRec(datos, mid+1, fin, valor);
        }
        return resu;    
    }    
}