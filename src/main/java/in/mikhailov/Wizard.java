package in.mikhailov;

public class Wizard extends Magician {
    private Wizard(int attack, int defense, int[] damage, int health, int speed, String name, int mana) {
        super(attack, defense, damage, health, speed, name, mana);
    }

    public Wizard(String name) {
        this(17, 12, new int[]{-5, -5}, 30, 9, name, 1);
    }

    public Wizard() {
        this("");
    }
}
