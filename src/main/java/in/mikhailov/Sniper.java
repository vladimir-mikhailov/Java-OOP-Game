package in.mikhailov;

public class Sniper extends Archer {

    private Sniper(int attack, int defense, int[] damage, int health, int speed, String name, int shots) {
        super(attack, defense, damage, health, speed, name, shots);
    }

    public Sniper(String name) {
        this(12, 10, new int[]{8, 10}, 15, 9, name, 32);
    }

    public Sniper() {
        this("");
    }

}
