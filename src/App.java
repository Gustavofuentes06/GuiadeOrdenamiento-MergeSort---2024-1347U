public class App {

    public static void mergeSort (int [] arr, int left, int right ){

        if (left < right) {
            // encuentra el punto medio del arreglo 
            int mid = (left + right)/2;

            //ordena recursivamente la mitad izquierda 
            mergeSort(arr, left, mid);

            //ordena recursivamente la mitad derecha
            mergeSort(arr, mid + 1, right);

            //combina las dos mitades ordenadas 
            merge(arr,left ,mid, right);

        }
    }
    private static void merge (int [] arr, int left, int mid ,int right ) {
        //tamaños de los subarreglos a fusionar 
        int sizeLeft = mid - left + 1; 
        int sizeRight = right - mid; 

        // Arreglos temporales para almacenar los subarreglos 
        int [] tempLeft = new int[sizeLeft];
        int [] tempRight = new int[sizeRight];

        //copia de datos a los arrelos tempporales 
        for (int i = 0; i < sizeLeft ; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight [j] = arr[mid + 1+ j];

            
        }
        
            //fusiona lo s subarreglos temporales en el arreglo original 
            int i = 0, j=0 ;
            int k= left; // Indice  inicial para el arreglo fusionado 
            
            while ( i < sizeLeft && j < sizeRight){
                if( tempLeft[i] <= tempRight[j]){
                    arr[k] = tempLeft[i];
                    i++;
                } else{
                    arr[k] = tempRight [j];
                    j++;
                }
                k++;

            }

            //copia elementod restantes de templeft[] si los hay 
            while (i < sizeLeft){
                arr[k] = tempLeft [i];
                i++;
                k++;
            }
            while (i < sizeRight){
                arr[k] = tempRight [j];
                j++;
                k++;
            }



    }
    public static void main(String[] args) throws Exception {

        int [] arr= {38,27,43,3,9,82,10};
        int n = arr.length;

        mergeSort(arr, 0 , n -1); // llamada al metodo de ordenamiento mergesort

        System.out.println("arreglo ordenado");
        for ( int num : arr) {
            System.out.println(num + " ");
        }
       
    }

    
}
