

![Binary Search](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Binary-search-work.gif/220px-Binary-search-work.gif "Binary  Search")

# Description
Binary Search


__Big O of 0(log n) as in the worst case it will traverse half of the list each time until it finds the item__
__Space complexity O(1) - since it will not use any addtional space outside of what currently was provisioned__  


# Use Cases

1. .
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


```
</p>
</details>
