package codechallenge.level2;

/**
 * You are spectating a programming contest with NN competitors, each trying to independently solve the same set of programming problems. Each problem has a point value, which is either 1, 2, or 3.
On the scoreboard, you observe that the iith competitor has attained a score of SiSi​, which is a positive integer equal to the sum of the point values of all the problems they have solved.
The scoreboard does not display the number of problems in the contest, nor their point values. Using the information available, you would like to determine the minimum possible number of problems in the contest.
Constraints
1≤N≤500,0001≤N≤500,000
1≤Si≤1,000,000,0001≤Si​≤1,000,000,000
Sample test case #1

N = 5
S = [1, 2, 3, 4, 5]

Expected Return Value = 3

Sample test case #2

N = 4
S = [4, 3, 3, 4]

Expected Return Value = 2

Sample test case #3

N = 4
S = [2, 4, 6, 8]

Expected Return Value = 4

Sample test case #4

N = 1
S = [8]

Expected Return Value = 3

Sample Explanation
In the first case, it's possible that there are as few as 33 problems in the contest, for example with point values [1,1,3][1,1,3]. The 55 competitors could have solved the following subsets of problems:

    Problem 11 (11 point)
    Problems 11 and 22 (1+1=21+1=2 points)
    Problem 33 (33 points)
    Problems 22 and 33 (1+3=41+3=4 points)
    All 33 problems (1+1+3=51+1+3=5 points)

It is impossible for all 55 competitors to have achieved their scores if there are fewer than 33 problems.
In the second case, one optimal set of point values is [1,3][1,3].
In the third case, one optimal set of point values is [2,2,2,2][2,2,2,2].
In the fourth case, one optimal set of point values is [2,3,3][2,3,3].
 */
public class scoreboardInference2 {
    public int getMinProblemCount(int N, int[] S) {
        // Write your code here
        return 0;
      }
}
