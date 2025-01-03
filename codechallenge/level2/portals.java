package codechallenge.level2;

/***
 * You've found yourself in a grid of cells with RR rows and CC columns. The cell in the iith row from the top and jjth column from the left contains one of the following (indicated by the character Gi,jGi,j​):

    If Gi,jGi,j​ = ".", the cell is empty.
    If Gi,jGi,j​ = "S", the cell contains your starting position. There is exactly one such cell.
    If Gi,jGi,j​ = "E", the cell contains an exit. There is at least one such cell.
    If Gi,jGi,j​ = "#", the cell contains a wall.
    Otherwise, if Gi,jGi,j​ is a lowercase letter (between "a" and "z", inclusive), the cell contains a portal marked with that letter.

Your objective is to reach any exit from your starting position as quickly as possible. Each second, you may take either of the following actions:

    Walk to a cell adjacent to your current one (directly above, below, to the left, or to the right), as long as you remain within the grid and that cell does not contain a wall.
    If your current cell contains a portal, teleport to any other cell in the grid containing a portal marked with the same letter as your current cell's portal.

Determine the minimum number of seconds required to reach any exit, if it's possible to do so at all. If it's not possible, return −1−1 instead.
Constraints
1≤R,C≤501≤R,C≤50
Gi,j∈Gi,j​∈ {".", "S", "E", "#", "a"..."z"}
Sample test case #1

R = 3
C = 3
G = .E.
    .#E
    .S#

Expected Return Value = 4

Sample test case #2

R = 3
C = 4
G = a.Sa
    ####
    Eb.b

Expected Return Value = -1

Sample test case #3

R = 3
C = 4
G = aS.b
    ####
    Eb.a

Expected Return Value = 4

Sample test case #4

R = 1
C = 9
G = xS..x..Ex

Expected Return Value = 3

Sample Explanation
In the first case, you can reach an exit in 44 seconds by walking left once, then up twice, and then finally right once.
In the second case, you can never reach the exit.
In the third case, you should walk right twice, then teleport to the cell in the 3rd row and 2nd column, and finally walk left once.
In the fourth case, you should walk left once, teleport to the cell in the last column, and walk left once more.
 */
public int getSecondsRequired(int R, int C, char[][] G) {
    // Write your code here
    return 0;
  }
  