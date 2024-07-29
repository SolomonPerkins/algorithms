/**
 * Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678


____
Solution Approach:
We must take care, however, to wrap around if we go past the last character. We don’t want to do 'Z' + 4 = '^'! We can use modular arithmetic once more to avoid this problem. Consider this pseudocode:

rotateCharacter(c, rotationFactor) {
    return ((c - 'A' + rotationFactor) % 26) + 'A';
}

c - 'A' will let us represent each letter as a number from [0, 25]. This step is necessary because the ASCII value of ‘A’ is not 0. We then add the rotation factor (and note that it isn’t actually necessary to reduce it beforehand) and then take this sum modulo 26 to get the [0, 25]-representation of the rotated character. We add ‘A’ back in at the end to translate this value back into the ASCII range of A-Z.
You can extend this code to properly handle characters in the ranges a-z and 0-9 as well.
 */
package codechallenge;

import java.util.*;
import  java.math.*;

public class RotationalChipher {
 // Add any helper functions you may need here
  

 String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    if(input == null) {
        return "";
    }
    StringBuilder sbuilder = new StringBuilder();
    HashMap<Character, String> cache = new HashMap<>();  
    
    //Loop through each character
    for(char c : input.toCharArray()) {
        char enc = c;

        //If cache hit was found use it instead.
        if(cache.containsKey(c)) {
            sbuilder.append(cache.get(c));
            continue;
        }

        if(Character.isLetterOrDigit(c)) {
            enc = (char) rotateCharacter(c, rotationFactor);
        }

        //addd  new item to cache
        cache.put(Character.valueOf(c), Character.toString(enc));
        //create string;
        sbuilder.append(Character.toString(enc));
    } 
    return sbuilder.toString();
  }



  public int rotateCharacter(char c, int rotationFactor) {
    char startLetter = '0';
    if(Character.isLetter(c)) {
        startLetter = Character.isUpperCase(c) ? 'A' : 'a';
    } 
    int moded = Character.isLetter(c) ? 26 : 10;
    return ((c - startLetter + rotationFactor) % moded) + startLetter;
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
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new RotationalChipher().run();
  }
}
