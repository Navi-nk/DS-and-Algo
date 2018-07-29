package sorting;

public class InsertionSort extends Sorting {

    public void sort(int[] inputArr) {
        final long startTime = System.currentTimeMillis();
        for (int i = 1; i < inputArr.length; i++) {
            int j = i;
            while (j-- > 0) {
                if (inputArr[j + 1] < inputArr[j]) {
                    int temp = inputArr[j + 1];
                    inputArr[j + 1] = inputArr[j];
                    inputArr[j] = temp;
                } else {
                    break;
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

}
