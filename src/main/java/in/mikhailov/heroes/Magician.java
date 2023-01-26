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
        Hero lowestHealthHero = null;
        int lowestHealthPoints = 5000;
        for (Hero hero: team) {
            if (hero.getHealth() < lowestHealthPoints && !hero.getClassName().equals("Peasant")) {
                lowestHealthPoints = hero.getHealth();
                lowestHealthHero = hero;
            }
                        
        }

        assert lowestHealthHero != null;
        if (lowestHealthHero.getMaxHealth() != lowestHealthPoints) {
            int newHealthPoints = Math.min((lowestHealthPoints + this.getAttack()), lowestHealthHero.getMaxHealth());
            lowestHealthHero.setHealth(newHealthPoints);
            System.out.println(this.getName() + " heals " + lowestHealthHero.getName() + " +" + (newHealthPoints - lowestHealthPoints) + " health points.");
            System.out.println("  =>  " + lowestHealthHero.getInfo());
        } else {
            System.out.println(className + " " + name + " tries to heal teammates, but their HP are full.");
        }
    }

}
