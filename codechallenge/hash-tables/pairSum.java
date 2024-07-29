/**
 * Pair Sums
Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
Signature
int numberOfWays(int[] arr, int k)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000,000,000].
k is in the range [1, 1,000,000,000].
Output
Return the number of different pairs of elements which sum to k.
Example 1
n = 5
k = 6
arr = [1, 2, 3, 4, 3]
output = 2
The valid pairs are 2+4 and 3+3.
Example 2
n = 5
k = 6
arr = [1, 5, 3, 3, 3]
output = 4
There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
 */
package codechallenge;

import java.util.*;

public class pairSum {

    // Add any helper functions you may need here
  

  int numberOfWays(int[] arr, int k) {
    Arrays.sort(arr);
    // Write your code here
    int len = arr.length;
    int left = 0;
    int right = len -1;
    int totalPairs = 0;
    HashMap<Integer, Integer> occurence = new HashMap<>();
    for(int i = 0; i < len - 1 && arr[i] < k; i++) {
        occurence.put(arr[i], occurence.getOrDefault(arr[i], 0) + 1);
    }

    //loop through each stopping when left and right pointer are the same
    for(; left < right && arr[left] != arr[right]; ) {
        int s = sum(arr, left, right);
        //if left val >=  k skip and move back
        if(s < k) {
            left += 1;
        }

        //if right val >= k , skip and move down
        if(s > k) {
            right -= 1;
        }

        if(s == k) {
            //keep hash of occurance
            totalPairs += 1;
            left += 1;
            right -=1;
        }

    }

    return totalPairs + calculateDuplicates(occurence, k);
  }

  int sum(int[] arr, int left, int right) {
    return arr[left] + arr[right];
  }

  int calculateDuplicates(HashMap<Integer, Integer> occ, int k) {
    int total = 0;
    for(Integer key : occ.keySet()) {
        Integer w = occ.get(key) / 2;
        if(occ.get(key) > 1 && key * 2 == k) {
            total += (w * (w -  1) /2 );
        }
    }

    return total;
  }













  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  
  public void run() {
    int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new pairSum().run();
  }
}
