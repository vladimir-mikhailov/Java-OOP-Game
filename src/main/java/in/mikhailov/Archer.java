package in.mikhailov;

public class Archer extends Hero {
    private int shots;

    public Archer(int attack, int defense, int[] damage, int health, int speed, String name, int shots) {
        super(attack, defense, damage, health, speed, name);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + ", shots=" + shots;
    }

    public int getShots() {
        return shots;
    }
}
