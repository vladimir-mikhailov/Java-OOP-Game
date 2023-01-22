package in.mikhailov.groups;

import in.mikhailov.heroes.Hero;
import in.mikhailov.heroes.Peasant;

public class Team extends Group {

    public Team() {
        super();
        super.capacity = 10;
    }

    @Override
    public boolean add(Hero hero) {
        super.add(hero);
        hero.setTeam(this);
        return super.group.contains(hero) && hero.getTeam() == this;
    }

    public boolean hasFreePeasant() {
        for (Hero hero: group) {
            if (hero.getClassName().equals("Peasant")) {
                Peasant peasant = (Peasant) hero;
                if (peasant.isFree()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Peasant nextFreePeasant() {
        for (Hero hero: group) {
            if (hero.getClassName().equals("Peasant")) {
                Peasant peasant = (Peasant) hero;
                if (peasant.isFree()) {
                    return peasant;
                }
            }
        }
        return null;
    }

    public void makeMove() {
        System.out.println("\nTeam " + name + " moves:");
        group.forEach(hero -> {
            if (!hero.getClassName().equals("Peasant")) hero.step();
        });
        group.forEach(hero -> {
            if (hero.getClassName().equals("Peasant")) hero.step();
        });
    }
}
