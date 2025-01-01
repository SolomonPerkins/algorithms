package codechallenge.sort;

import java.util.Comparator;

public class PlayerSort implements Comparator<Player> {
  
    @Override
    public int compare(Player a, Player b) {
        if(a.score == b.score) {
            return a.name.compareTo(b.name);
        } 
        return a.score - b.score;
    }

}
