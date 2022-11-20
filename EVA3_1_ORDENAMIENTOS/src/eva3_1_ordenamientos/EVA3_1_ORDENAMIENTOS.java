package eva3_1_ordenamientos;

/**
 * @author José Sebastian López Ibarra
 * Wedneday November 16 2022
 */

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        
        // Creamos los arreglos correspondientes:
        int[] arregloDatos = new int[10];
        int[] copiaArreglo = new int[arregloDatos.length];
        int[] segundaCopia = new int[arregloDatos.length];
        
        // Llenamos los arreglos:
        fillArray(arregloDatos);
        fillArray(copiaArreglo);
        fillArray(segundaCopia);
        
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
        System.out.println("\nMétodo Insertion Sort: ");
        insertionSort(segundaCopia);
    }
    
    // Método que llena un arreglo con números enteros aleatorios.
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
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
}
