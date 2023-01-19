package in.mikhailov;

import com.github.javafaker.Faker;

import java.util.Arrays;

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

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
