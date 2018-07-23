
package sorting;

public class CustomBinarySearch {
    
    static public int doSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target)
               return mid;
            if( arr[mid] > target)
                right = mid - 1;
            else if( arr[mid] < target)
                left = mid + 1;
        }
        return -1;
    }
    
}
