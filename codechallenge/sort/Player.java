package codechallenge.sort;

public class Player {
    String name;
    Integer score;

    Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "name=" + name + " | score: " + score;
    }
}
