package sorting;

public class SelectionSort extends Sorting {

    @Override
    void sort(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            int minimum = i;
            int traverse = i;
            while (traverse < inputArr.length) {
                if (inputArr[traverse] < inputArr[minimum]) {
                    minimum = traverse;
                }
                traverse++;
            }
            int temp = inputArr[minimum];
            inputArr[minimum] = inputArr[i];
            inputArr[i] = temp;
        }
    }

}
