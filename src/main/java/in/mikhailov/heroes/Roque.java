package in.mikhailov.heroes;

public class Roque extends Melee {
    private Roque(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    public Roque(String name) {
        this(8, 3, new int[]{3, 5}, 40, 6, name);
    }

    public Roque() {
        this("");
    }
}
