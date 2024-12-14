package codechallenge.stack;

/**
 * Convert words to number,
 * for example: 
 * input = fifteen
 * output = 15
 * 
 * input = two hundred and eleven
 * output = 211
 * 
 * input = negative five thousand and sixty four
 * output = - 5064
 */
import static java.util.Map.entry;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class wordToNumber {
    Map<String, Integer> quotaMap = Map.ofEntries(
        entry("zero", 0),
        entry("one", 1),
        entry("two", 2),
        entry("twen", 2),
        entry("three", 3),
        entry("thir", 3),
        entry("four", 4),
        entry("for", 4),
        entry("five", 5),
        entry("fif", 5),
        entry("six", 6),
        entry("seven", 7),
        entry("eight", 8),
        entry("nine", 9),
        entry("ten", 10),
        entry("eleven", 11),
        entry("twelve", 12),
        entry("hundred", 100),
        entry("thousand", 1000),
        entry("million", 1000000),
        entry("bimillion", 1000000000),
        
        entry("negative", -1),
        entry("and", 0)
    );

    Map<String, Integer> suffix = Map.ofEntries(
        entry("teen", 10),
        entry("ty", 10)
    );


    private void addToQueue(Queue<Integer> queue, List<String> words) {
        for (String word : words) {
            //convert word to integer
            Integer number = 0;
            if(this.quotaMap.containsKey(word)) {
                number = this.quotaMap.get(word);
            } else {
            // TODO convert complex words
                if(word.endsWith("teen")) {
                  number = this.quotaMap.get(word.substring(0, word.length() - 4)) + 10;  
                } else if(word.endsWith("ty")) {
                    number = this.quotaMap.get(word.substring(0, word.length() - 2)) * 10;                         
                } 
            }
            queue.add(number);
        }

    }

    private Integer calculate(Queue<Integer> queue, Integer num, Integer count) {
        if(queue.isEmpty()) {
            return num;
        }
        Integer node = queue.remove();
        Integer next = queue.peek();

        if(node == null) {
            return num;
        }

        if(node == -1) {
            return num * -1;
        }

        if(node > 0 && node % 100 == 0) {
            queue.remove();
            return calculate(queue, ((node * next) + num), count + 1);
        } else { 
            return calculate(queue, node + num, count + 1);
        }
    }


    public void run() {
        String sentence = "nineteen thousand and twenty nine";
        Queue<Integer> queue = new LinkedList<Integer>();
        // reverse the word
        
        // convert each word to number and put it on the stack
        addToQueue(queue, Arrays.asList(sentence.split(" ")).reversed());

        // pop each from stack recursively 
            // 100 % == 0 -> pop X num
            // else -> pop + num
        System.out.printf("For word: %s\n\n Stack: %s", sentence, queue.toString());
        System.out.printf("\nConversion is: %d\n", calculate(queue, 0, 0));
        System.out.println();
    }

    public static void main(String[] args) {
        new wordToNumber().run();
      }
}
