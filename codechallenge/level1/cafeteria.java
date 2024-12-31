/**
 * A cafeteria table consists of a row of NN seats, numbered from 11 to NN from left to right. Social distancing guidelines require that every diner be seated such that KK seats to their left and KK seats to their right (or all the remaining seats to that side if there are fewer than KK) remain empty.
There are currently MM diners seated at the table, the iith of whom is in seat SiSi​. No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
Please take care to write a solution which runs within the time limit.
Constraints
1≤N≤10151≤N≤1015
1≤K≤N1≤K≤N
1≤M≤500,0001≤M≤500,000
M≤NM≤N
1≤Si≤N1≤Si​≤N
Sample test case #1

N = 10
K = 1
M = 2
S = [2, 6]

Expected Return Value = 3

Sample test case #2

N = 15
K = 2
M = 3
S = [11, 6, 14]

Expected Return Value = 1

Sample Explanation
In the first case, the cafeteria table has N=10N=10 seats, with two diners currently at seats 22 and 66 respectively. The table initially looks as follows, with brackets covering the K=1K=1 seat to the left and right of each existing diner that may not be taken.

  1 2 3 4 5 6 7 8 9 10
  [   ]   [   ]

Three additional diners may sit at seats 44, 88, and 1010 without violating the social distancing guidelines.
In the second case, only 11 additional diner is able to join the table, by sitting in any of the first 33 seats.
 */

package codechallenge.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  
/**
 * ANOTHER OPTION OF USIGN THE 
 * identify available space = N / ((K + 1) * M)
 * Edge cases: need to handle when items are at the end or close to the end.
 */

 /**
  * STRUCTURE | ALGORITHM
  * 1. Sort to ascending
    2. Base - Calculate space taken: 2K + 1 (2 times number of social distance + space occupied by customer)
    3. Calculate available space for:
      1. start to first seat
      2. Between each diner
      3. last diner to the end
  * 
  */



  public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
    // Write your code here
    long additionalDiners = 0;
    long socialDistance =  K + 1;
        
    if(S.length == 0) {
      return (long) Math.round(N / (K + 1));
    }
    if(S.length == N) {
      return 0;
    }

    Arrays.sort(S);

    // left occupied size
    additionalDiners += (S[0] - 1)/ socialDistance;

    // end - start / (2k+1))
    additionalDiners += (N - S[S.length - 1]) / socialDistance;

    //for each occupany if it they are adjacent make a note of it.
    for(int row = 0; row < (M - 1); row++) {
        long diner1 = S[row];
        long diner2 = S[row + 1];
        additionalDiners += (diner2 - diner1 - socialDistance) / socialDistance;
    }
    
    return additionalDiners;
  
  }
  
}