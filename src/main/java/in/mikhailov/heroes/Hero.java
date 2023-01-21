package in.mikhailov.heroes;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public abstract class Hero implements HeroInterface {
    protected String name;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
    private int speed;
    private int[] damage;
    protected List<Hero> team;
    protected String className;



    protected Hero(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = this.maxHealth;
        this.speed = speed;
        this.name = name.isEmpty() ? (new Faker()).name().firstName() : name;
        this.className = this.getClass().getName().split("\\.")[3];
    }

    protected int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    protected int getMaxHealth() { return maxHealth; }

    protected void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public int getHealth() {
        return health;
    }

    public String getClassName() {
        return className;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected int[] getDamage() {
        return damage;
    }

    protected void setDamage(int[] damage) {
        this.damage = damage;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  className +
                " name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", damage=" + Arrays.toString(damage) +
                ", health: " + this.health + "/" + maxHealth +
                ", speed=" + speed;
    }

    @Override
    public String getInfo() {
        return name + ", " + className + " >> Health: " + this.health + "/" + maxHealth;
    }

    @Override
    public void step() {
    }

    @Override
    public void setTeam(List<Hero> team) {
        this.team = team;
    }

}