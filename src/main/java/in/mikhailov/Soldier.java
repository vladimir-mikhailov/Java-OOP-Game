package in.mikhailov;

import java.util.ArrayList;

public class Soldier extends Hero {
    public Soldier(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    @Override
    public void step(ArrayList<Hero> heroesParty) {

    }
}
