package in.mikhailov.heroes;

public class Spearman extends Soldier {
    private Spearman(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    public Spearman(String name) {
        this(4, 5, new int[]{1, 3}, 10, 4, name);
    }

    public Spearman() {
        this("");
    }
}
