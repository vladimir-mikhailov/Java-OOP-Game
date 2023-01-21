package in.mikhailov;

import in.mikhailov.groups.*;
import in.mikhailov.heroes.*;

public class Main {
    public static void main(String[] args) {

        RandomFactory team1RandomFactory = new RandomFactory(new HeroFactory[]{
                new PeasantFactory(),
                new RoqueFactory(),
                new SniperFactory(),
                new WizardFactory()
        });

        RandomFactory team2RandomFactory = new RandomFactory(new HeroFactory[]{
                new CrossbowmanFactory(),
                new MonkFactory(),
                new PeasantFactory(),
                new SpearmanFactory(),
        });

        TeamFactory teamFactory = new TeamFactory();
        Team dreamTeam1 = teamFactory.create();
        Team dreamTeam2 = teamFactory.create();

        while (dreamTeam1.getSize() < dreamTeam1.getCapacity()) {
            dreamTeam1.add(team1RandomFactory.create());
        }

        while (dreamTeam2.getSize() < dreamTeam2.getCapacity()) {
            dreamTeam2.add(team2RandomFactory.create());
        }

        System.out.println("Party1 heroes:");
        dreamTeam1.sort("className");
        dreamTeam1.forEach(hero -> System.out.println(hero.getInfo()));

        System.out.println("\nParty 1 moves:");
        while (dreamTeam1.hasNext()) {
            dreamTeam1.next().step();
        }

        System.out.println("\nParty2 heroes:");
        dreamTeam2.sort("healthPoints");
        dreamTeam2.forEach(hero -> System.out.println(hero.getInfo()));

        System.out.println("\nParty 2 moves:");
        while (dreamTeam2.hasNext()) {
            dreamTeam2.next().step();
        }

    }
}