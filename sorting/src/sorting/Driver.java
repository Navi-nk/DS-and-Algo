package sorting;

import java.math.MathContext;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        int arr[] = {3, 63, 1, 66, 75, 32, 22, 1342, 52, 6, 666, 2225, 4};
        System.out.println("Array to be sorted:");
        printArray(arr);
        System.out.println("Enter sorting algorithm choice");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Bubble Sort");
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
            default:
                System.out.println("In valid Choice");
        }

        printArray(arr);
        System.out.println(CustomBinarySearch.doSearch(arr, 2225));
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}
