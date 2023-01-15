package in.mikhailov;

public class Peasant extends Hero {
    private boolean isCarrier;

    private Peasant(int attack, int defense, int[] damage, int health, int speed, String name) {
        super(attack, defense, damage, health, speed, name);
        this.isCarrier = true;
    }

    public Peasant(String name) {
        this(1, 1, new int[] {1, 1}, 1, 3, name);
    }

    public Peasant() {
        this("");
    }

    @Override
    public String toString() {
        return super.toString() + ", isCarrier=" + isCarrier;
    }

    public boolean isCarrier() {
        return isCarrier;
    }
}
