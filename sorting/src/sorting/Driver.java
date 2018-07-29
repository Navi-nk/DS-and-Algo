package sorting;

import java.math.MathContext;
import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        int[] arr = new int[20];
        generateRandomArray(arr, arr.length);
        System.out.println("Array to be sorted:");
        printArray(arr);
        
        System.out.println("Enter sorting algorithm choice");
        System.out.println("0. Test All");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Quick Sort (last pivot)");
        System.out.println("6. Quick Sort (random pivot)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                new InsertionSort().sort(arr);
                break;
            case 2:
                new SelectionSort().sort(arr);
                break;
            case 3:
                new MergeSort().sort(arr);
                break;
            case 4:
                new BubbleSort().sort(arr);
                break;
            case 5:
                new QuickSort(false).sort(arr);
                break;
            case 6:
                new QuickSort(true).sort(arr);
                break;
            case 0:
                new InsertionSort().sort(arr);
                printArray(arr);
                generateRandomArray(arr, arr.length);
                new SelectionSort().sort(arr);
                printArray(arr);
                generateRandomArray(arr, arr.length);
                new MergeSort().sort(arr);
                printArray(arr);
                generateRandomArray(arr, arr.length);
                new BubbleSort().sort(arr);
                printArray(arr);
                generateRandomArray(arr, arr.length);
                new QuickSort(false).sort(arr);
                printArray(arr);
                break;
            default:
                System.out.println("In valid Choice");
        }

        printArray(arr);
        System.out.println(CustomBinarySearch.doSearch(arr, 1));
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    private static void generateRandomArray(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt(len);
        }
    }
}
