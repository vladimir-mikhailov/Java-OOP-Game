package in.mikhailov.heroes;

public class Archer extends Hero {
    private int shots;

    public Archer(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int shots) {
        super(attack, defense, damage, maxHealth, speed, name);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + ", shots=" + shots;
    }

    @Override
    public void step() {

    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getShots() {
        return shots;
    }

}
