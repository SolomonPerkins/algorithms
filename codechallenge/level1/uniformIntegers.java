/**
 * A positive integer is considered uniform if all of its digits are equal. For example, 222222 is uniform, while 223223 is not.
Given two positive integers AA and BB, determine the number of uniform integers between AA and BB, inclusive.
Please take care to write a solution which runs within the time limit.
Constraints
1≤A≤B≤10121≤A≤B≤1012
Sample test case #1

A = 75
B = 300

Expected Return Value = 5

Sample test case #2

A = 1
B = 9

Expected Return Value = 9

Sample test case #3

A = 999999999999
B = 999999999999

Expected Return Value = 1

Sample Explanation
In the first case, the uniform integers between 7575 and 300300 are 7777, 8888, 9999, 111111, and 222222.
In the second case, all 99 single-digit integers between 11 and 99 (inclusive) are uniform.
In the third case, the single integer under consideration (999,999,999,999999,999,999,999) is uniform.
 */
package codechallenge;

import java.util.Arrays;

public class uniformIntegers {
    public int getUniformIntegerCountInInterval(long A, long B) {
        // Write your code here
        int count = 0;
        if(A <= 9) {
            return (int)A;
        }

        if(A == 10) {
            return 9;
        }
        
        for(long i = A; i <= B; i++) {
            //loop from 1-9
            for(int j = 1; j <= 9; j++) {
                char[] arr = new char[(int)i]; 
                Arrays.fill(arr, Character.valueOf((char)j));
                long num = Long.valueOf(String.join("-", new String(arr)).replace("-", ""));

                if(num > B) {
                    break;
                }
                count+=1;
            }
        }
        return count;
      }

}
