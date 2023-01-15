package in.mikhailov;

public class Monk extends Magician {
    private Monk(int attack, int defense, int[] damage, int health, int speed, String name, int mana) {
        super(attack, defense, damage, health, speed, name, mana);
    }

    public Monk(String name) {
        this(12, 7, new int[]{-4, -4}, 30, 5, name, 1);
    }

    public Monk() {
        this("");
    }
}
