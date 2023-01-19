package in.mikhailov;

import java.util.ArrayList;

public class Peasant extends Hero {
    private boolean isCarrier;

    private Peasant(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
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

    @Override
    public void step(ArrayList<Hero> heroesParty) {

    }

    public boolean isCarrier() {
        return isCarrier;
    }

    public void setCarrier(boolean carrier) {
        isCarrier = carrier;
    }
}
