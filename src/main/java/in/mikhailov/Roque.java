package in.mikhailov;

public class Roque extends Soldier {
    private Roque(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    public Roque(String name) {
        this(8, 3, new int[]{2, 4}, 10, 6, name);
    }

    public Roque() {
        this("");
    }
}
