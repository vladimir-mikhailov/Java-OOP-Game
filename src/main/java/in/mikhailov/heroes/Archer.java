package in.mikhailov.heroes;

public class Archer extends Hero {
    private int maxShots;
    private int shots;

    public Archer(int attack, int defense, int[] damage, int maxHealth, int speed, String name, int maxShots) {
        super(attack, defense, damage, maxHealth, speed, name);
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
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + ", shots=" + shots;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Shots: " + shots + "/" + maxShots + ".";
    }

    @Override
    public void step() {
        if (shots > 0) {
            System.out.println(className + " " + name + " shoots." );
            if (team.hasFreePeasant()) {
                Peasant freePeasant = team.nextFreePeasant();
                System.out.println(freePeasant.className + " " + freePeasant.name + " brought an arrow to " + className + " " + name + ".");
                freePeasant.setFree(false);
            } else {
                shots--;
                System.out.println(className + " " + name + " has " + shots + "/" + maxShots + " shots left." );
            }
        } else System.out.println(className + " " + name + " tries to shoot, but he has run out of arrows." );
    }

}
