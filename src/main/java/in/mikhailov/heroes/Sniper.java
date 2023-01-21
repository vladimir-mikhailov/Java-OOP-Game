package in.mikhailov.heroes;

public class Sniper extends Archer {

    private Sniper(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int shots) {
        super(attack, defense, damage, maxHealth, speed, name, shots);
    }

    public Sniper(String name) {
        this(12, 10, new int[]{8, 10}, 15, 9, name, 32);
    }

    public Sniper() {
        this("");
    }

}
