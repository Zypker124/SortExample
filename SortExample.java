package other_programs;

import java.util.ArrayList;
/**
 *    SortExample - Sorts an array of Integers in ascending order.
 *
 *    @author Mr Greenstein
 *    @version November 15, 2016
 */
public class SortExample {
    
    /**
     *    Bubble Sort algorithm - in ascending order
     *    @param arr        array of Integer objects to sort
     */
    public static void bubbleSort(Integer [] arr) {
        for(int end = arr.length - 1; end > 0; end--){
            for(int a = 0; a < end; a++){
                int result = arr[a].compareTo(arr[a+1]);
                if(result > 0){
                    swap(arr, a, a+1);
                }
            }
        }
    }
    
    /**
     *    Swaps two Integer objects in array arr
     *    @param arr        array of Integer objects
     *    @param x        index of first object to swap
     *    @param y        index of second object to swap
     */
    private static void swap(Integer[] arr, int x, int y) {
        Integer temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    /**
     *    Selection Sort algorithm - in ascending order (you implement)
     *    @param arr        array of Integer objects to sort
     */
    public static void selectionSort(Integer [] arr) {
        for(int end = arr.length; end > 1; end--){
            int maximum = 0;
            for(int ind = 1; ind < end; ind++){
            	if(arr[ind]>arr[maximum]){
            		maximum=ind;
            	}
            }
            
            swap(arr,maximum,end);
        }
    }
    
    /**
     *    Insertion Sort algorithm - in ascending order (you implement)
     *    @param arr        array of Integer objects to sort
     */
    public static void insertionSort(Integer [] arr) {
    //    ArrayList<Integer> leftSide = new ArrayList<Integer>;
       // leftSide.add();
        for(int index = 1; index < arr.length; index++){
            Integer arrTemp = new Integer(arr[index]);
            
            int i = index;
            while(i > 0 && arrTemp < arr[i-1]){
            	arr[i] = arr[i-1];
                i--;
            }
            
            arr[i] = arrTemp;
        }
        
    }
    
    /**
     *    Merge Sort algorithm - in ascending order (you implement)
     *    @param arr        array of Integer objects to sort
     */
     private static Integer[] temp;
    public static void mergeSort(Integer [] arr) {
        int arrLength = arr.length;
        temp = new Integer[arrLength];
        recursiveSort(arr, 0, arrLength-1);
    }
    
    public static void recursiveSort(Integer[] arr, int from, int to){
        if( to-from < 2){
            if( to > from && arr[to] < arr[from] ){
                Integer arrTemp = arr[to];
                arr[to] = arr[from];
                arr[from] = arrTemp;
            }
        }else{
            int middle = (from + to)/2;
            recursiveSort(arr, from, middle);
            recursiveSort(arr, middle+1, to);
            merge(arr, from, middle, to);
        }
    }
    
    public static void merge(Integer[] arr, int from, int middle, int to){
        Integer i = new Integer(from);
        Integer j = new Integer(middle+1);
        Integer k = new Integer(from);
        while(i<= middle && j <= to){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i <= middle){
            temp[k] = arr[i];
            i++;
            k++;
        }
        
        while(j <= to){
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        for(k = from; k <= to; k++){
            arr[k] = temp[k];
        }
    }
    
    /**
     *
     * */
    public static void printArray(Integer[] arr) {
        for (int a = 0; a < arr.length; a++)
            System.out.print(arr[a] + "  ");
        System.out.println();
    }
    /**
     * Main class where code is run
     * */
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        for (int a = 0; a < 10; a++) {
            int random = (int)(Math.random() * 100) + 1;
            arr[a] = random;
        }
        System.out.println("\nBubble Sort");
        System.out.println("Array before sort:");
        printArray(arr);
        System.out.println();
        bubbleSort(arr);
        System.out.println("Array after sort:");
        printArray(arr);
        System.out.println();
    
        for (int a = 0; a < 10; a++) {
            int random = (int)(Math.random() * 100) + 1;
            arr[a] = random;
        }
        System.out.println("\nSelection Sort");
        System.out.println("Array before sort:");
        printArray(arr);
        System.out.println();
        selectionSort(arr);
        System.out.println("Array after sort:");
        printArray(arr);
        System.out.println();
        
        for (int a = 0; a < 10; a++) {
            int random = (int)(Math.random() * 100) + 1;
            arr[a] = random;
        }
        System.out.println("\nInsertion Sort");
        System.out.println("Array before sort:");
        printArray(arr);
        System.out.println();
        insertionSort(arr);
        System.out.println("Array after sort:");
        printArray(arr);
        System.out.println();
        
        for (int a = 0; a < 10; a++) {
            int random = (int)(Math.random() * 100) + 1;
            arr[a] = random;
        }
        System.out.println("\nMerge Sort");
        System.out.println("Array before sort:");
        printArray(arr);
        System.out.println();
        mergeSort(arr);
        System.out.println("Array after sort:");
        printArray(arr);
        System.out.println();

    }
}