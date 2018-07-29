package sorting;

public class QuickSort extends Sorting {

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

    private int partition(int[] inputArr, int low, int pivot) {
        int i = low;
        for (int j = low; j < pivot; j++) {
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
