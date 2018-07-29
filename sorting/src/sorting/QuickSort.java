package sorting;

import java.util.Random;

public class QuickSort extends Sorting {

    private boolean isRandomPivot;

    public QuickSort(boolean isRandomPivot) {
        this.isRandomPivot = isRandomPivot;
    }

    @Override
    void sort(int[] inputArr) {
        final long startTime = System.currentTimeMillis();
        quicksort(inputArr, 0, inputArr.length - 1);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    private void quicksort(int[] inputArr, int low, int high) {
        if (low < high) {
            int p = partition(inputArr, low, high);
            quicksort(inputArr, low, p - 1);
            quicksort(inputArr, p + 1, high);
        }
    }

    private int partition(int[] inputArr, int low, int high) {
        if (isRandomPivot) {
            int pivot = new Random().ints(low, high + 1).limit(1).findFirst().getAsInt();
            int temp = inputArr[high];
            inputArr[high] = inputArr[pivot];
            inputArr[pivot] = temp;
        }
        int i = low;
        int pivot = high;
        for (int j = low; j < high; j++) {
            if (inputArr[j] < inputArr[pivot]) {
                if (i != j) {
                    int temp = inputArr[i];
                    inputArr[i] = inputArr[j];
                    inputArr[j] = temp;
                }
                i++;
            }
        }
        int temp = inputArr[pivot];
        inputArr[pivot] = inputArr[i];
        inputArr[i] = temp;
        return i;
    }
}
