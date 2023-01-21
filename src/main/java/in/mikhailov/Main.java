package in.mikhailov;

import in.mikhailov.groups.Team;
import in.mikhailov.groups.TeamFactory;
import in.mikhailov.heroes.*;

import java.util.Scanner;

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

        printTeamStatus(dreamTeam1);
        printTeamStatus(dreamTeam2);

        System.out.print("\n Для продолжения нажмите <Enter>, для выхода <Q>: ");

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            if (input.nextLine().isEmpty()) {
                printTeamStatus(dreamTeam1);
                printTeamStatus(dreamTeam2);

                dreamTeam1.makeMove();
                dreamTeam2.makeMove();

                System.out.print("\n Для продолжения нажмите <Enter>, для выхода <Q>: ");
            }
        }
    }

    private static void printTeamStatus(Team team) {
        System.out.println(team.getName() + " Castle Heroes:");
        //team.sort("className");
        team.forEach(hero -> System.out.println(hero.getInfo()));
        System.out.println();
    }
}