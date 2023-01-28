package in.mikhailov.heroes;

public class Magician extends Hero {

    private int mana;

    public Magician(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int mana) {
        super(attack, defense, damage, maxHealth, speed, name);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + " 🪄" + mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void step() {
        if (health == 0) return;

        Hero lowestHealthHero = null;
        float lowestHealthPoints = 1000;
        for (Hero hero: team) {
            if (hero.getHealth() > 0 && hero.getHealth() < hero.getMaxHealth() && hero.getHealth() < lowestHealthPoints) {
                lowestHealthPoints = hero.getHealth();
                lowestHealthHero = hero;
            }
        }

        if (lowestHealthHero != null) {
            lowestHealthHero.takeDamage(this.getDamage()[0]);
            System.out.println(this.getName() + " heals " + lowestHealthHero.getName() + " +" + -this.getDamage()[0] + " health points.");
        } else {
            System.out.println(className + " " + name + " tries to heal teammates, but their HP are full.");
        }
    }

}
