package in.mikhailov;

public class Magician extends Hero {

    private int mana;

    public Magician(int attack, int defense, int[] damage, int health, int speed, String name, int mana) {
        super(attack, defense, damage, health, speed, name);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana=" + mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
