package codechallenge.recursion;

import java.math.*;

public class encryptWord {

    // Add any helper functions you may need here
  

  String findEncryptedWord(String s) {
    // Write your code here
    StringBuilder bldr = new StringBuilder();
    if(s.length() <= 1)  return s;
    int mid  = s.length() % 2 == 1 ? s.length() / 2 : (s.length() - 1) /  2;
    char  midChar = s.charAt(mid);

    return bldr
        .append(String.valueOf(midChar))
        .append(findEncryptedWord(s.substring(0, mid)))
        .append(findEncryptedWord(s.substring(mid +  1, s.length())))
        .toString(); 
  }










  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected); 
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    String s_1 = "abc";
    String expected_1 = "bac";
    String output_1 = findEncryptedWord(s_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String expected_2 = "bacd";
    String output_2 = findEncryptedWord(s_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }

  public static void main(String[] args) {
    new encryptWord().run();
  }
  
}
