package codechallenge.sort;

import java.util.Arrays;
import java.util.Comparator;



public class comparatorBasic {
    public static  void  main(String[] args) {
        Player[] players = {
            new Player("Bob", 1),
            new Player("Tom", 2),
            new Player("Mark", 3),
            new Player("Andrew", 3)
        };

        Arrays.asList(players).sort(new PlayerSort());

        
        for(Player p : players) {
        System.out.printf("%s\n", p);
        }
    }
}
