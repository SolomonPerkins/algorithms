/**
 * Balance Brackets
A bracket is any of the following characters: (, ), {, }, [, or ].
We consider two brackets to be matching if the first bracket is an open-bracket, e.g., (, {, or [, and the second bracket is a close-bracket of the same type. That means ( and ), [ and ], and { and } are the only pairs of matching brackets.
Furthermore, a sequence of brackets is said to be balanced if the following conditions are met:

    The sequence is empty, or
    The sequence is composed of two or more non-empty sequences, all of which are balanced, or
    The first and last brackets of the sequence are matching, and the portion of the sequence without the first and last elements is balanced.

You are given a string of brackets. Your task is to determine whether each sequence of brackets is balanced. If a string is balanced, return true, otherwise, return false
Signature
bool isBalanced(String s)
Input
String s with length between 1 and 1000
Output
A boolean representing if the string is balanced or not
Example 1
s = {[()]}
output: true
Example 2
s = {}()
output: true
Example 3
s = {(})
output: false
Example 4
s = )
output: false
 */
package codechallenge.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class balanceBrackets {
    boolean isBalanced(String s) {
        // Write your code here
        if(s.isEmpty()) {
            return true;
        }

        Stack stack = new Stack<>();
        HashMap<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('{', '}');
        parenthesis.put('(', ')');
        parenthesis.put('[', ']');
        
        for(char c : s.toCharArray()) {
            if(parenthesis.containsKey(c)) {
                stack.push(parenthesis.get(c));
            } else if(parenthesis.containsValue(c) && Character.valueOf(c) != stack.pop()){
                return false;
            }
        }

        return stack.size() == 0;
    }    
    
    
    
    
    
    
    
    
    
      // These are the tests we use to determine if the solution is correct.
      // You can add your own at the bottom.
      int test_case_number = 1;
      void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
          System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
          System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
          System.out.print(expected); 
          System.out.print(" Your output: ");
          System.out.print(output);
          System.out.println();
        }
        test_case_number++;
      }
      void printString(String str) {
        System.out.print("[" + str + "]");
      }
      
      public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);
    
        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);
    
        // Add your own test cases here
            
      }
      
      public static void main(String[] args) {
        new balanceBrackets().run();
      }
}
