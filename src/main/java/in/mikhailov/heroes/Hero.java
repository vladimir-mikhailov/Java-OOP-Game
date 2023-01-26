package in.mikhailov.heroes;

import com.github.javafaker.Faker;
import in.mikhailov.battleField.Cell;
import in.mikhailov.groups.Team;

public abstract class Hero implements HeroInterface {
    protected String name;
    protected Team team;
    protected String className;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
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

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
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
        return String.format("%-8s", "💚" + this.health + "/" + maxHealth) +
                String.format("%-5s", "⚔️" + attack) +
                String.format("%-7s", "👊" + (damage[0] == damage[1] ? damage[0] : damage[0] + "-" + damage[1])) +
                String.format("%-6s", "🛡️" + defense) +
                String.format("%-5s", "🏃" + speed);
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
}