package in.mikhailov.heroes;

import java.util.HashMap;

public abstract class RangeAttacker extends Hero {
    private int maxShots;
    private int shots;
    private int range;

    public RangeAttacker(int attack, int defence, int[] damage, int maxHealth, int speed, String name, int maxShots) {
        super(attack, defence, damage, maxHealth, speed, name);
        this.maxShots = maxShots;
        this.shots = this.maxShots;
    }

    public int getMaxShots() {
        return maxShots;
    }

    public void setMaxShots(int maxShots) {
        this.maxShots = maxShots;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        if (shots > this.maxShots) this.shots = this.maxShots;
        else this.shots = Math.max(shots, 0);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return super.toString() + " 🏹" + shots;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                String.format("%-8s", "🏹" + shots + "/" + maxShots);
    }

    @Override
    public void step() {
        setRandomPriority();
        if (this.getHealth() == 0) return;
        if (shots > 0) {
            HashMap<Hero, Float> nearestOpponent = getNearestOpponent();
            Hero opponentHero = nearestOpponent.keySet().stream().toList().get(0);
            float distance = nearestOpponent.values().stream().toList().get(0);

            if (opponentHero != null) {
                float damageAmount;
                final float MAX_DISTANCE = 12.7279f;
                int minDamage = this.getDamage()[0];
                int maxDamage = this.getDamage()[1];
                if (distance <= this.getRange()) damageAmount = maxDamage;
                else {
                    float coefficient = (distance - range) / (MAX_DISTANCE - range);
                    damageAmount = minDamage + coefficient * (maxDamage - minDamage);
                }
                if (opponentHero.getDefense() > this.getAttack()) damageAmount--;
                else if (opponentHero.getDefense() < this.getAttack()) damageAmount++;

                shots--;
                System.out.println(className + " " + name +
                        " shoots at " + opponentHero.getClassName() + " " + opponentHero.getName() +
                        " 👊" + (int) damageAmount + " 🏹" + shots + "/" + maxShots);
                opponentHero.takeDamage(damageAmount);

            } else {
                System.out.println(this.getClassName() + " " + this.getName() + " wanted to shoot, but could not find the target.");
            }

        } else System.out.println(className + " " + name + " wanted to shoot, but he has run out of arrows.");
    }

}
