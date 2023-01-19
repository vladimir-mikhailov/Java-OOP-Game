package in.mikhailov;

import java.util.ArrayList;

public class Magician extends Hero {

    private int mana;

    public Magician(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int mana) {
        super(attack, defense, damage, maxHealth, speed, name);
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

    @Override
    public void step(ArrayList<Hero> heroesParty) {
        int lowestHealthHeroIndex = 0;
        int lowestHealthPoints = heroesParty.get(0).getHealth();
        for (int i = 1; i < heroesParty.size(); i++) {
            Hero currentHero = heroesParty.get(i);
            int currentHeroHealth = currentHero.getHealth();
            if (currentHeroHealth < lowestHealthPoints && !currentHero.getClass().getName().contains("Peasant")) {
                lowestHealthPoints = currentHeroHealth;
                lowestHealthHeroIndex = i;
            }
        }

        Hero damagedHero = heroesParty.get(lowestHealthHeroIndex);
        if (damagedHero.getMaxHealth() != lowestHealthPoints) {
            int newHealthPoints = Math.min((lowestHealthPoints + this.getAttack()), damagedHero.getMaxHealth());
            damagedHero.setHealth(newHealthPoints);
            System.out.println(this.getName() + " heals " + damagedHero.getName() + " +" + (newHealthPoints - lowestHealthPoints) + " health points");
            System.out.println("  =>  " + damagedHero.getInfo());
        } else {
            System.out.println("Party's HP are full");
        }
    }

}
