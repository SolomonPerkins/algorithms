package codechallenge.search;

/**
 * BINARY SEARCH
 * Ref: https://medium.com/techie-delight/binary-search-practice-problems-4c856cd9f26c
 * 
 * Find the first or last occurrence of a given number in a sorted array
 * 
 * Given a sorted integer array, find the index of a given number’s first or last occurrence. If the element is not present in the array, report that as well.
 * For example,
 * 
 * Input:
 *  nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9] 
 *  target = 5  
 * Output:   The first occurrence of element 5 is located at index 1 The last occurrence of element 5 is located at index 3    
 *  
 * Input: 
 *  nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9] 
 *  target = 4  
 * Output:   Element not found in the array 
 * 
 * 
 * Approach:
 *  To find the element’s last occurrence, modify the standard binary search to continue searching even on finding the target. 
 *  Instead, update the result to mid and go on searching towards the right (towards higher indices), 
 *  i.e., modify our search space by adjusting low to mid+1 on finding the target at mid-index.
 * 
 * 
 **/
public class firstOrLastOccurance {

    static boolean searchOccurance(int[] arr, int key) {
        if(arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        
        int first = -1;
        int last = -1;

        while(left <= right) {
            //if target found, try search for first and last occurence
            int mid = left + ((right  - left) /2);
            if(arr[mid] == key) {
                if(arr[left] == key) {
                    first = left;
                } else {
                    left += 1;
                }

                if(arr[right] == key) {
                    last = right;
                } else {
                    right -= 1;
                }

                if(first > -1 && last > -1) {
                    System.out.println("First occurance is index: " + first);
                    System.out.println("Last occurance is index: " + last);
                    return true;
                }
            }

            if(key < arr[mid]) {
                right = mid -1;
            } else  if (key > arr[mid]) {
                left = mid + 1;
            }

        }

        return false;
    }

    public static  void  main(String[] args) {
        int arr[] = {2,5,5,5,6,6,8,9,9,9};
        int key = 5;

        

        System.out.println("Found: " + searchOccurance(arr, key));
    }


}
