package in.mikhailov.heroes;

import java.util.List;

public class Peasant extends Hero {
    boolean isFree;
    private final boolean isCarrier;

    private Peasant(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
        this.isCarrier = true;
        isFree = true;
    }

    public Peasant(String name) {
        this(1, 1, new int[]{1, 1}, 1, 3, name);
    }

    public Peasant() {
        this("");
    }

    @Override
    public String toString() {
        return super.toString() + (isCarrier ? " 🏋️‍♂️" : "");
    }

    @Override
    public void step() {
        if (health == 0) return;

        List<RangeAttacker> rangeAttackers = this.getTeam().getHeroes().stream().filter(hero -> hero.getClass().getSuperclass().getName().contains("RangeAttacker")).map(hero -> (RangeAttacker) hero).toList();
        RangeAttacker rangeAttackerRecipient = null;
        int minPercent = 100;
        for (RangeAttacker rangeAttacker : rangeAttackers) {
            if (rangeAttacker.getShots() < rangeAttacker.getMaxShots()) {
                int currentPercent = rangeAttacker.getShots() / rangeAttacker.getMaxShots() * 100;
                if (currentPercent < minPercent) minPercent = currentPercent;
                rangeAttackerRecipient = rangeAttacker;
            }
        }
        if (rangeAttackerRecipient != null) {
            rangeAttackerRecipient.setShots(rangeAttackerRecipient.getShots() + 1);
            System.out.println(className + " " + name + " brought an arrow to " + rangeAttackerRecipient.getClassName() + " " + rangeAttackerRecipient.getName());
        } else System.out.println(className + " " + name + " wanted to bring an arrow to some archer, but no archers need more arrows.");
    }

}
