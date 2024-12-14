package codechallenge;

import java.util.HashMap;

public class revenueMilestone {
// Add any helper functions you may need here
  

int[] getMilestoneDays(int[] revenues, int[] milestones) {
    // Write your code here
    HashMap<Integer, Integer> tally = new HashMap<>();
    int len = milestones.length;
    int[] daysAchieved = new int[len];

    //set all to -1 by default
    for(int d = 0; d < len; d++) {
        daysAchieved[d] = -1;
    }

    tally.put(0, revenues[0]); //set the first value as total rev.
    //loop through and calculate the cumulative sum of all days
    for(int day = 1;  day < revenues.length; day++) {
        int prevday = day - 1;
        tally.put(day, tally.getOrDefault(prevday, 0) + revenues[day]); //today's rev is prev rev + current re
    }

    //loop through until all tally then match
    int target = 0;
    for(int d = 1; d <= tally.size();) {
        if(target >= len) { //exit if we're  at the end of the milestones
            break;
        }

        if(tally.get(d - 1) >= milestones[target]) { //if milestone reached then go to next item
            daysAchieved[target] = d; //set the day in which the target was met
            target += 1; //go to the next item            
            d = 1;
            continue;
        } 

        if(tally.get(d - 1) < milestones[target]) { //go right if we haven't met the summation
            d +=1;
        }    
    }
    

    return daysAchieved;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  public void run() {
    int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};
    int expected_1[] = {2, 4, 4, 5};
    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
    check(expected_1, output_1);
    
    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    int expected_2[] = {5, 4, 2, 3, 2};
    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new revenueMilestone().run();
  }
}
