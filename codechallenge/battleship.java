/**
 * You're playing Battleship on a grid of cells with RR rows and CC columns. There are 00 or more battleships on the grid, each occupying a single distinct cell. The cell in the iith row from the top and jjth column from the left either contains a battleship (Gi,j=1Gi,j​=1) or doesn't (Gi,j=0Gi,j​=0).
You're going to fire a single shot at a random cell in the grid. You'll choose this cell uniformly at random from the R∗CR∗C possible cells. You're interested in the probability that the cell hit by your shot contains a battleship.
Your task is to implement the function getHitProbability(R, C, G) which returns this probability.
Note: Your return value must have an absolute or relative error of at most 10−610−6 to be considered correct.
Constraints
1≤R,C≤1001≤R,C≤100
0≤Gi,j≤10≤Gi,j​≤1
Sample test case #1

R = 2
C = 3
G = 0 0 1
    1 0 1

Expected Return Value = 0.50000000

Sample test case #2

R = 2
C = 2
G = 1 1
    1 1

Expected Return Value = 1.00000000

Sample Explanation
In the first case, 33 of the 66 cells in the grid contain battleships. Therefore, the probability that your shot will hit one of them is 3/6=0.53/6=0.5.
In the second case, all 44 cells contain battleships, resulting in a probability of 1.01.0 of hitting a battleship.
 */
package codechallenge;

public class battleship {

    public static double getHitProbability(int R, int C, int[][] G) {
        // Write your code here
        int ships = countShips(R, C, G);  
        return (double)(ships / (double) (R * C));
    }
  
    private static int countShips(int R, int C, int[][] G) {
        int count = 0;
        int hasShip = 1;

        //iterate over all the elements in one go
        /**
         * Formula : row * column
         */
        for(int i = 0; i < R * C; i++ ){
            int  row = i / C;
            int col = i % C;

            if(G[row][col] == hasShip) {
                System.out.println("Ships found at: " + row +" c="+ col);
                count += 1;
            }
        }

        System.out.printf("Total ships: %d\n", count);

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1},
            {1,0,1}
        };
        System.out.printf("Probability: %f", getHitProbability(2,  3, grid));
    }
    
}
