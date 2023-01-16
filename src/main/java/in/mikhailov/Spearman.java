package in.mikhailov;

public class Spearman extends Soldier {
    private Spearman(int attack, int defense, int[] damage, int health, int speed, String name) {
        super(attack, defense, damage, health, speed, name);
    }

    public Spearman(String name) {
        this(4, 5, new int[]{1, 3}, 10, 4, name);
    }

    public Spearman() {
        this("");
    }
}
