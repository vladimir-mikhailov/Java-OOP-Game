package in.mikhailov.heroes;

public class Spearman extends Melee {
    private Spearman(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    public Spearman(String name) {
        this(7, 10, new int[]{3, 4}, 60, 5, name);
    }

    public Spearman() {
        this("");
    }
}
