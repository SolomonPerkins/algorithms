package codechallenge.level2;

/**
 * SEE rotaryLock.png
 * 
 * You're trying to open a lock. The lock comes with two wheels, each of which has the integers from 11 to NN arranged in a circle in order around it (with integers 11 and NN adjacent to one another). Each wheel is initially pointing at 11.
For example, the following depicts the lock for N=10N=10 (as is presented in the second sample case).
It takes 11 second to rotate a wheel by 11 unit to an adjacent integer in either direction, and it takes no time to select an integer once a wheel is pointing at it.
The lock will open if you enter a certain code. The code consists of a sequence of MM integers, the iith of which is CiCi​. For each integer in the sequence, you may select it with either of the two wheels. Determine the minimum number of seconds required to select all MM of the code's integers in order.
Constraints
3≤N≤1,000,000,0003≤N≤1,000,000,000
1≤M≤3,0001≤M≤3,000
1≤Ci≤N1≤Ci​≤N
Sample test case #1

N = 3
M = 3
C = [1, 2, 3]

Expected Return Value = 2

Sample test case #2

N = 10
M = 4
C = [9, 4, 4, 8]

Expected Return Value = 6

Sample Explanation
In the first case, there are 33 integers on the locks, and the sequence of integers to be selected is [1,2,3][1,2,3]. One optimal way to enter the code is: select 11 on the first lock →→ rotate the first lock to 22 (11 second) →→ select 22 →→ rotate the second lock from 11 backwards to 33 (11 second) →→ select 33. The total time taken is 1+1=21+1=2 seconds.
In the second case, the locks each consists of the integers 11 through 1010, and the sequence to be selected is [9,4,4,8][9,4,4,8]. One optimal way to enter the code is: rotate the first lock from 11 backwards to 99 (22 seconds) →→ select 99 →→ rotate the second lock forwards from 11 to 44 (33 seconds) →→ select 44 twice →→ rotate the first lock from 99 backwards to 88 (11 second) →→ select 88. The total time taken is 2+3+1=62+3+1=6 seconds.
 */
public class rotateLock2 {
    public long getMinCodeEntryTime(int N, int M, int[] C) {
        // Write your code here
        return 0L;
      }
      
}
