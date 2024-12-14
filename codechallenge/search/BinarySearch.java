package codechallenge.search;
import java.util.logging.Logger;
import java.util.Arrays;

public class BinarySearch {
    static int search(int arr[], int low, int high, int key) {
        System.out.printf("Calling low=%d, high=%d\n", low, high);
        if(high < low) {
            return -1;
        }

        int mid = (low + high) / 2;
        if(key == arr[mid]) {
            return mid;
        }

        if(key > arr[mid]) {
            return search(arr, mid + 1, high, key); // search for upper  end
        }
        return search(arr, low, (mid - 1), key);//search lower end
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
