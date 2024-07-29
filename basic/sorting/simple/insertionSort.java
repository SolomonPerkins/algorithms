package basic.sorting.simple;

import java.util.*;

public class insertionSort {

    public static void sort(int arr[]) {
        int length = arr.length;
        if(length == 0) {
            return;
        }

        for(int i = 1; i < length;  i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        
        int arr[] = {10, 6, 9, 8, 4, 5};
        // sort(arr);

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.err.printf(" %d => ", arr[i]);
        }
    }
    
}
