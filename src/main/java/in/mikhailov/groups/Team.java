package in.mikhailov.groups;

import in.mikhailov.heroes.Hero;

public class Team extends Group {
    private final String color;
    private Team opponentTeam;

    public Team(String color) {
        super();
        this.setCapacity(10);
        this.color = color;
    }

    @Override
    public void add(Hero hero) {
        super.add(hero);
        hero.setTeam(this);
    }

    public String getColor() {
        return color;
    }


    public Team getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(Team opponentTeam) {
        this.opponentTeam = opponentTeam;
    }
}
