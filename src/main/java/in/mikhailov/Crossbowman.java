package in.mikhailov;

public class Crossbowman extends Archer {

    public Crossbowman(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int shots) {
        super(attack, defense, damage, maxHealth, speed, name, shots);
    }

    public Crossbowman(String name) {
        this(6, 3, new int[]{2, 3}, 10, 4, name, 16);
    }

    public Crossbowman() {
        this("");
    }
}
