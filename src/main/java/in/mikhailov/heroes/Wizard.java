package in.mikhailov.heroes;

public class Wizard extends Magician {
    private Wizard(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int mana) {
        super(attack, defense, damage, maxHealth, speed, name, mana);
    }

    public Wizard(String name) {
        this(17, 4, new int[]{-5, -5}, 30, 4, name, 1);
    }

    public Wizard() {
        this("");
    }
}
