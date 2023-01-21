package in.mikhailov.heroes;

public class Soldier extends Hero {
    public Soldier(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    @Override
    public void step() {

    }
}
