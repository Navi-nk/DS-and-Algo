package sorting;

public class InsertionSort extends Sorting{

    public void sort(int[] inputArr) {
        for (int i = 1; i < inputArr.length; i++) {
            int j = i;
            while (j-- > 0) {
                if (inputArr[j + 1] < inputArr[j]) {
                     int temp = inputArr[j+1];
                    inputArr[j+1] = inputArr[j];
                    inputArr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

}
