package in.mikhailov.heroes;

public class Soldier extends Hero {
    public Soldier(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    @Override
    public void step() {
        if (health == 0) return;
        System.out.println(className + " " + name + " is resting because he hasn't learned how to fight yet.");
    }
}
