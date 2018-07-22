
package sorting;

public class Driver {
    public static void main(String[] args){
        Integer arr[] = {3,63,1,66,75,32,22,1342,52,6,666,2225,4};
        printArray(arr);
        InsertionSort.sort(arr);
        printArray(arr);
    }

    private static void printArray(Integer[] arr) {
        for(int a : arr){
            System.out.print(a +" ");
        }
        System.out.println("");
    }
}
