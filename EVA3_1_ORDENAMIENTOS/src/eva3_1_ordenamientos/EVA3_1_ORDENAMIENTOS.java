package eva3_1_ordenamientos;

/**
 * @author José Sebastian López Ibarra
 * Wedneday November 16 2022
 */

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        // Creamos los arreglos correspondientes:
        
        int[] arregloDatos = new int[15];
        int[] arregloSel = new int[15];
        int[] arregloIns = new int[15];
        
        fill(arregloDatos);
        fill(arregloSel);
        fill(arregloIns);
    }
    
    // Método que llena un arreglo con números enteros aleatorios
    public static void fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
    }
    
    // Método de ordenamiento Selection Sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
 
        }
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
            array[insP] = temp;
        }
    }
    
}
