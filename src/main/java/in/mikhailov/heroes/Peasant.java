package in.mikhailov.heroes;

public class Peasant extends Hero {
    boolean isFree;
    private boolean isCarrier;

    private Peasant(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
        this.isCarrier = true;
        isFree = true;
    }

    public Peasant(String name) {
        this(1, 1, new int[] {1, 1}, 1, 3, name);
    }

    public Peasant() {
        this("");
    }

    @Override
    public String toString() {
        return super.toString() + ", isCarrier=" + isCarrier;
    }

    @Override
    public void step() {
        if (!isFree) {
            System.out.println(className + " " + name + " has done a good job and is free now.");
            setFree(true);
        } else {
            System.out.println(className + " " + name + " is idle because there is no work for him.");
        }
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
