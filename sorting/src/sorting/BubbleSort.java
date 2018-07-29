
package sorting;

public class BubbleSort extends Sorting{

    @Override
    void sort(int[] inputArr) {
        final long startTime = System.currentTimeMillis();
        for(int i=0; i<inputArr.length; i++){
            for(int j=i; j<inputArr.length; j++){
                if(inputArr[j]<inputArr[i]){
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[i];
                    inputArr[i] = temp;
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    
}
