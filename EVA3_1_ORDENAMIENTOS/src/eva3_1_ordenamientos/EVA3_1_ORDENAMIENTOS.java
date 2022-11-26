package eva3_1_ordenamientos;

/**
 * @author José Sebastian López Ibarra 
 * Wedneday November 16 2022
 */

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {

        float ini, end;

        // Creamos los arreglos correspondientes:
        int[] arregloDatos = new int[10];
        int[] copiaArreglo = new int[arregloDatos.length];
        int[] segundaCopia = new int[arregloDatos.length];
        int[] arregloQ = new int[arregloDatos.length];

        // Llenamos los arreglos:
        fillArray(arregloDatos);
        fillArray(copiaArreglo);
        fillArray(segundaCopia);
        fillArray(arregloQ);

        // Imprimimos los arreglos:
        System.out.println("Arreglo Original:");
        printArray(arregloDatos);
        System.out.println("\nCopia del arreglo original:");
        copyArray(arregloDatos, copiaArreglo);
        System.out.println("\nSegundo copia del arreglo original:");
        copyArray(arregloDatos, segundaCopia);
        System.out.println();

        // Utilizamos los métodos Selection e Insertion Sort:
        System.out.println("\nMétodo Selection Sort: ");
        selectionSort(copiaArreglo);
        // ini = System.nanoTime();
        // System.out.println("Tiempo de ejecución: " + ini);
        System.out.println("\nMétodo Insertion Sort: ");
        insertionSort(segundaCopia);
        // end = System.nanoTime();
        // System.out.println("Tiempo de ejecución: " + end);

        // Utilizamos el método Quick Sort:
        System.out.println("\nMétodo Quick Sort: ");
        copyArray(arregloDatos, arregloQ);
        ini = System.nanoTime();
        quickSort(arregloQ);
        end = System.nanoTime();
        printArray(arregloQ);
        System.out.println("Quick sort = " + (end - ini));
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
    }

    // Método de ordenamiento recursivo Quick Sort:
    private static void quickSortRecur(int[] arreglo, int ini, int fin) {
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
            while (arreglo[big] <= arreglo[pivote] && big < small) { // Buscar los elementos mas grandes que el pivote
                big++;
            }

            while (arreglo[small] > arreglo[pivote]) { // Buscar los elementos mas pequeños que el pivote
                small--;
            }

            // Verificamos que no se hayan cruzado, si hay intercambiamos
            if (big < small) {
                temp = arreglo[big];
                arreglo[big] = arreglo[small];
                arreglo[small] = temp;
            }
        }

        // Intercambiamos (swap) pivote con small
        temp = arreglo[pivote];
        arreglo[pivote] = arreglo[small];
        arreglo[small] = temp;
        pivote = small;

        // Llamada recursiva 
        if (ini < pivote) {
            quickSortRecur(arreglo, ini, pivote - 1);
        }

        if (fin > pivote) {
            quickSortRecur(arreglo, pivote + 1, fin);
        }
    }
}
