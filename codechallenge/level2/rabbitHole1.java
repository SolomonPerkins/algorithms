package codechallenge.level2;

/**
 * You're having a grand old time clicking through the rabbit hole that is your favorite online encyclopedia.
The encyclopedia consists of NN different web pages, numbered from 11 to NN. Each page ii contains nothing but a single link to a different page LiLi​.
A session spent on this website involves beginning on one of the NN pages, and then navigating around using the links until you decide to stop. That is, while on page ii, you may either move to page LiLi​, or stop your browsing session.
Assuming you can choose which page you begin the session on, what's the maximum number of different pages you can visit in a single session? Note that a page only counts once even if visited multiple times during the session.
Constraints
2≤N≤500,0002≤N≤500,000
1≤Li≤N1≤Li​≤N
Li≠iLi​=i
Sample test case #1

N = 4
L = [4, 1, 2, 1]

Expected Return Value = 4

Sample test case #2

N = 5
L = [4, 3, 5, 1, 2]

Expected Return Value = 3

Sample test case #3

N = 5
L = [2, 4, 2, 2, 3]

Expected Return Value = 4

Sample Explanation
In the first case, you can visit all 44 pages in a single browsing session if you begin on page 33. For example, you can visit the sequence of pages 3→2→1→43→2→1→4.
In the second case, you can only visit at most 33 different pages −− for example, the sequence of pages 3→5→23→5→2.
In the third case, you can only visit at most 44 different pages −− for example, the sequence of pages 5→3→2→45→3→2→4.
 */
public class rabbitHole1 {
      
  public int getMaxVisitableWebpages(int N, int[] L) {
    // Write your code here
    return 0;
  }
  
}
