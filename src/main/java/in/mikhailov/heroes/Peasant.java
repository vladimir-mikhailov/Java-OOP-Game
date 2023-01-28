package in.mikhailov.heroes;

import java.util.List;

public class Peasant extends Hero {
    boolean isFree;
    private boolean isCarrier;

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

        List<Archer> archers = this.getTeam().getHeroes().stream().filter(hero -> hero.getClass().getSuperclass().getName().contains("Archer")).map(hero -> (Archer) hero).toList();
        Archer archerRecipient = null;
        int minPercent = 100;
        for (Archer archer : archers) {
            if (archer.getShots() < archer.getMaxShots()) {
                int currentPercent = archer.getShots() / archer.getMaxShots() * 100;
                if (currentPercent < minPercent) minPercent = currentPercent;
                archerRecipient = archer;
            }
        }
        if (archerRecipient != null) {
            archerRecipient.setShots(archerRecipient.getShots() + 1);
            System.out.println(className + " " + name + " brought an arrow to " + archerRecipient.getClassName() + " " + archerRecipient.getName());
        } else System.out.println(className + " " + name + " wanted to bring an arrow to some archer, but no archers need more arrows.");
    }

    public boolean isCarrier() {
        return isCarrier;
    }

    public void setCarrier(boolean carrier) {
        isCarrier = carrier;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

}
