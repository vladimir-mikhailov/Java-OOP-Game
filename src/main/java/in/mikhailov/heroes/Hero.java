package in.mikhailov.heroes;

import com.github.javafaker.Faker;
import in.mikhailov.battle.Cell;
import in.mikhailov.groups.Team;

import java.util.HashMap;

public abstract class Hero implements HeroInterface {
    protected String name;
    protected Team team;
    protected String className;
    private int attack;
    private int defense;
    private int maxHealth;
    protected float health;
    private int speed;
    private int[] damage;
    private Cell cell;

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

    protected int getMaxHealth() {
        return maxHealth;
    }

    protected void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getHealth() {
        return health;
    }

    protected void setHealth(float health) {
        this.health = health;
    }

    public String getClassName() {
        return className;
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

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + className + getInfo();
    }

    @Override
    public String getInfo() {
        return String.format("%-8s", "💚" + (int) this.health + "/" + maxHealth) +
                String.format("%-5s", "⚔️" + attack) +
                String.format("%-7s", "👊" + (damage[0] == damage[1] ? damage[0] : damage[0] + "-" + damage[1])) +
                String.format("%-6s", "🛡️" + defense) +
                String.format("%-5s", "🏃" + speed);
    }


    @Override
    public void takeDamage(float damageCaused) {
        this.setHealth(this.getHealth() - damageCaused);
        if (this.getHealth() < 0) this.setHealth(0);
        else if (this.getHealth() > this.getMaxHealth()) this.setHealth(this.getMaxHealth());

        if (health == 0) System.out.println(className + " " + name + " is dead ☠️");
    }

    public char getChar() {
        return className.charAt(0);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    protected HashMap<Hero, Float> getNearestOpponent() {
        HashMap<Hero, Float> nearestOpponent = new HashMap<>(1);
        Hero nearestHero = null;
        float minDistance = 15;
        for (Hero oppHero: this.getTeam().getOpponentTeam()) {
            if (oppHero.getHealth() > 0) {
                int oppX = oppHero.getCell().getX();
                int oppY = oppHero.getCell().getY();
                float distance = (float) Math.sqrt(Math.pow(oppY - this.getCell().getY(),2) + Math.pow(oppX - this.getCell().getX(), 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestHero = oppHero;
                }
            }
        }
        nearestOpponent.put(nearestHero, minDistance);
        return nearestOpponent;
    }
}