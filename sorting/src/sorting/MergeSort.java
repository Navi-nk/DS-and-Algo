package sorting;

public class MergeSort extends Sorting {

    @Override
    void sort(int[] inputArr) {
        final long startTime = System.currentTimeMillis();
        mergeSort(inputArr, 0, inputArr.length - 1);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    private void mergeSort(int[] inputArr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(inputArr, start, mid);
            mergeSort(inputArr, mid + 1, end);
            merge(inputArr, start, end);
        }
    }

    private void merge(int[] inputArr, int start, int end) {
        int len = end - start;
        int i = 0;
        int mid = len / 2;
        int j = mid + 1;
        int k = start;

        int[] tempArr = new int[len + 1];

        for (int z = 0; z < len + 1; z++) {
            tempArr[z] = inputArr[start + z];
        }

        while (i <= mid && j <= len) {
            if (tempArr[i] <= tempArr[j]) {
                inputArr[k] = tempArr[i];
                i++;
            } else {
                inputArr[k] = tempArr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            inputArr[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
