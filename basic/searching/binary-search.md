

![Binary Search](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Binary-search-work.gif/220px-Binary-search-work.gif "Binary  Search")

# Description
Binary Search is use to efficiently find an item within a *sorted list*


__Big O of 0(log n) as in the worst case it will traverse half of the list each time until it finds the item__
__Space complexity O(1) - since it will not use any addtional space outside of what currently was provisioned__  


# Use Cases

1. Sorted list or items
2. .
3. 


## Scenarios:

+ ``

  + > .

+ ``

# Disadvantages

1. 
2. 
3. 
4. 

# Pseudocode

1. 
2. 
3. .





# Code Snippet


<details>
<summary>Binary Search</summary>

<p>

```java

import java.util.logging.Logger;
import java.util.Arrays;

public class BinarySearch {
    static int searchRecursive(int arr[], int left, int right, int key) {
        System.out.printf("Calling left=%d, right=%d\n", left, right);
        if(right < left) {
            return -1;
        }
        // To prevent an overflow avoid using: 
        //  int mid = (left + right) / 2;
        // instead use mid = left + ((left - right) / 2)
        int mid = left  + ((right - left) / 2);
        if(key == arr[mid]) {
            return mid;
        }

        if(key > arr[mid]) {
            return searchRecursive(arr, mid + 1, right, key); // search for upper  end
        }
        return searchRecursive(arr, left, (mid - 1), key);//search lower end
    }

    static boolean searchIterative(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1; //start left at end
        while(left <= right) {
            // to prevent overflow
            int mid = left + ((right - left) /2);
            // if  key found
            if  (arr[mid] == key) {
                return true; 
            } else if ( key < arr[mid]) {
                right = mid - 1;
            } else {
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

        System.out.println("Index: " + searchRecursive(arr, 0, n, key));
        System.out.printf("INDEX IS: %d\n", Arrays.binarySearch(arr, 0, n, key));
    
}


```
</p>
</details>
