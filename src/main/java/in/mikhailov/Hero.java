package in.mikhailov;

import java.util.Arrays;
import com.github.javafaker.Faker;

public abstract class Hero {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int speed;
    private int[] damage;

    protected Hero(int attack, int defense, int[] damage, int health, int speed, String name) {
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.name = name.isEmpty() ? (new Faker()).name().firstName() : name;
    }

    @Override
    public String toString() {
        return this.getClass().getName().split("\\.")[2] +
                " name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", speed=" + speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int[] getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
