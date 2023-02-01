package in.mikhailov.heroes;

public class Crossbowman extends RangeAttacker {

    public Crossbowman(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int shots) {
        super(attack, defense, damage, maxHealth, speed, name, shots);
    }

    public Crossbowman(String name) {
        this(10, 6, new int[]{6, 8}, 20, 9, name, 16);
    }

    public Crossbowman() {
        this("");
    }
}
