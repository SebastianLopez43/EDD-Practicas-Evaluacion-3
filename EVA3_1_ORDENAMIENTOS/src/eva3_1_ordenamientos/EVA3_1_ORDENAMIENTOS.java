package eva3_1_ordenamientos;

/**
 * @author José Sebastian López Ibarra 
 * Wedneday November 16 2022
 */

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {

        long inicioS, inicioI, inicioQ;

        // Creamos los arreglos correspondientes:
        int[] arregloDatos = new int[10];
        int[] arregloS = new int[arregloDatos.length];
        int[] arregloI = new int[arregloDatos.length];
        int[] arregloQ = new int[arregloDatos.length];

        // Llenamos los arreglos:
        fillArray(arregloDatos);
        fillArray(arregloS);
        fillArray(arregloI);
        fillArray(arregloQ);
        
        System.out.println("Arreglo Original:");
        printArray(arregloDatos);        

        // Utilizamos los métodos Selection, Insertion Sort y Quick Sort:
        System.out.println("\nMétodo Selection Sort: ");
        copyArray(arregloDatos, arregloS);        
        selectionSort(arregloS);
        inicioS = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + inicioS);
        
        System.out.println("\nMétodo Insertion Sort: ");
        copyArray(arregloDatos, arregloI);
        insertionSort(arregloI);
        inicioI = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + inicioI);

        System.out.println("\nMétodo Quick Sort: ");
        copyArray(arregloDatos, arregloQ);
        quickSort(arregloQ);
        inicioQ = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + inicioQ);
    }

    // Método que llena un arreglo con números enteros aleatorios.
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    // Método que imprime un arreglo.
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 10) {
                System.out.print("[0" + array[i] + "]");
            } else {
                System.out.print("[" + array[i] + "]");
            }
        }
        System.out.println();
    }

    // Método que crea una copia de un arreglo.
    public static void copyArray(int[] array, int[] copy) {
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        printArray(array);
    }

    // Método de ordenamiento Selection Sort.
    public static void selectionSort(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) { // Búsqueda de posición
                if (array[min] > array[j]) { // Buscamos el mínimo
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        printArray(array);
    }

    // Friday November 18 2022
    // Método de ordenamiento Insertion Sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i]; // Lo que se va a ordenar
            int insP = i;
            // Buscamos en que punto debe quedar temp, esa posición queda almacenada en insP
            for (int prev = i - 1; prev >= 0; prev--) { // Comparamos
                if (array[prev] > temp) {
                    // Swap (Intercambio parcial)
                    array[insP] = array[prev];
                    insP--;
                } else {
                    break;
                }
            }
            if (temp != array[insP]) {
                array[insP] = temp;
            }
        }
        printArray(array);
    }

    // Método de ordenamiento Quick Sort:
    public static void quickSort(int[] array) {
        quickSortRecur(array, 0, array.length - 1);
        printArray(array);
    }

    // Método de ordenamiento recursivo Quick Sort:
    private static void quickSortRecur(int[] array, int ini, int fin) {
        /*
        Pivote -> posicion 
        
        Dos indices:
        - big_ind -> Busca los mayores al pivote
        - small_ind -> Busca los menores al pivote

        Si se encuentran valores, se intercambian
        Si se cruzan, se intercambia el pivote con small_ind

        Quicksort a cada lado del pivote
         */

        int pivote, big, small, temp;  //La variable temp es para hacer swap
        pivote = ini;
        big = ini;
        small = fin;

        while (big < small) { // Los indices se cruzaron

            // Mover los indices 
            while (array[big] <= array[pivote] && big < small) { // Buscar los elementos mas grandes que el pivote
                big++;
            }

            while (array[small] > array[pivote]) { // Buscar los elementos mas pequeños que el pivote
                small--;
            }

            // Verificamos que no se hayan cruzado, si hay intercambiamos
            if (big < small) {
                temp = array[big];
                array[big] = array[small];
                array[small] = temp;
            }
        }

        // Intercambiamos (swap) pivote con small
        temp = array[pivote];
        array[pivote] = array[small];
        array[small] = temp;
        pivote = small;

        // Llamada recursiva 
        if (ini < pivote) {
            quickSortRecur(array, ini, pivote - 1);
        }

        if (fin > pivote) {
            quickSortRecur(array, pivote + 1, fin);
        }                
    }
}
