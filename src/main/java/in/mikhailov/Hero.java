package in.mikhailov;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Hero implements HeroInterface{
    private String name;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
    private int speed;
    private int[] damage;

    protected Hero(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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
                ", health=" + maxHealth +
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

    public int getMaxHealth() { return maxHealth; }

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

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


    @Override
    public String getInfo() {
        return name + ", " + this.getClass().getName().split("\\.")[2] +
                 " >> Health: " + this.health + "/" + maxHealth;
    }

    @Override
    public void step(ArrayList<Hero> heroesParty) {

    }

}