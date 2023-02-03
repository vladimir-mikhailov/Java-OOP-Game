package in.mikhailov.heroes;

import in.mikhailov.battle.Cell;
import in.mikhailov.groups.Team;

public abstract class Magician extends Hero {

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
        setRandomPriority();
        if (isPass()) {
            setPass(false);
            return;
        }
        if (health == 0) return;

        for (Hero deadHero: team) {
            if (deadHero.getHealth() == 0) {

                Cell tempCell = deadHero.getCell();
                Team tempTeam = deadHero.getTeam();
                int index = tempTeam.getHeroes().indexOf(deadHero);

                System.out.println(this.getClassName() + " " + this.getName() +
                        " resurrects " + deadHero.getName());

                Hero newHero = team.getRandomFactory().create();
                newHero.setCell(tempCell);
                tempCell.setHero(newHero);
                newHero.setTeam(tempTeam);

                tempTeam.getHeroes().set(index, newHero);
                setPass(true);

                System.out.println(newHero.getClassName() + " " + newHero.getName() +
                        " now alive ✨");

                return;
            }
        }

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
            System.out.println(this.getClassName() + " " + this.getName() +
                    " heals " + lowestHealthHero.getName() + " 💚+" + -this.getDamage()[0]);
        } else {
            System.out.println(className + " " + name + " wanted to heal teammates, but their HP are full.");
        }
    }

}
