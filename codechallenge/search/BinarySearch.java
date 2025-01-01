package codechallenge.search;
import java.util.logging.Logger;
import java.util.Arrays;

public class BinarySearch {
    static int search(int arr[], int left, int right, int key) {
        System.out.printf("Calling left=%d, right=%d\n", left, right);
        if(right < left) {
            return -1;
        }

        // int mid = (left + right) / 2; - this will cause an out of bound exception
        int mid = left  + ((right - left) / 2);
        if(key == arr[mid]) {
            return mid;
        }

        if(key > arr[mid]) {
            return search(arr, mid + 1, right, key); // search for upper  end
        }
        return search(arr, left, (mid - 1), key);//search lefter end
    }


    static boolean searchStr(String str, int left, int right, Character key) {
        if(str.isEmpty() || right > left){
            return false;
        }

        int  mid = left + ((right - left) / 2);
        if(str.charAt(mid) == key) {
            return true;
        } else if(Character.getNumericValue(key) < Character.getNumericValue(str.charAt(mid))) { // if key is less than mid, move right to mid - 1
            return searchStr(str, left, mid - 1, key);
        } else { // if  key is greater than mid, move left to mid + 1
            return searchStr(str, mid + 1, right, key);
        }
    }

    static boolean searchStrIterative(String str, Character  key) {
        if(str.isEmpty()) {
            return false;
        }
        int left = 0;
        int right = str.length() - 1;
        
        while(left <= right) {
            int mid = left + ((right  - left) / 2); // to prevent out of bounds
            if(str.charAt(mid) == key) { //  if mid is found break  and return
                return true;
            } else if (Character.getNumericValue(key) < Character.getNumericValue(str.charAt(mid))) { //  if key is less than mid, set right to mid - 1
                right = mid  - 1;
            } else{ // if key is more than mid, set left to mid + 1
                left = mid + 1;
            }
        }
        return false;
    }


    public static  void  main(String[] args) {
        
        int arr[] = { 5, 6, 7, 8,9, 9, 10, 20};
        int n, key;
        n = arr.length - 1;
        key = 10;

        System.out.println("Index: " + search(arr, 0, n, key));
        System.out.printf("INDEX IS: %d\n", Arrays.binarySearch(arr, 0, n, key));
    }


}
