package in.mikhailov;

import in.mikhailov.battle.*;
import in.mikhailov.battle.BattleField;
import in.mikhailov.groups.*;
import in.mikhailov.heroes.*;
import in.mikhailov.views.*;

import java.util.*;


public class Main {
    static Team team1;
    static Team team2;
    static Battle battle;

    public static void main(String[] args) {
        init();
        startBattle();
    }

    public static void init() {
        List<Team> teams = getTeams();
        team1 = teams.get(0);
        team2 = teams.get(1);
        BattleField battleField = new BattleField();
        battle = new Battle(team1, team2, battleField);
    }

    public static void startBattle() {
        ConsoleView.printBattleStatus(battle);
        System.out.println();
        ConsoleView.printMenu("start");

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            if (input.nextLine().isEmpty()) {
                battle.nextRound();

                ConsoleView.printRoundReport();
                ConsoleView.printBattleStatus(battle);
                System.out.println();
                ConsoleView.printMenu("nextRound");
            }
        }
    }

    public static List<Team> getTeams() {
        List<Team> teams = new ArrayList<>(2);

        TeamFactory teamFactory = new TeamFactory();
        Team team1 = teamFactory.create();
        team1.setColor("red");
        RandomFactory randomFactoryTeam1 = new RandomFactory(new HeroFactory[]{
                new PeasantFactory(),
                new RoqueFactory(),
                new SniperFactory(),
                new WizardFactory()
        });
        while (team1.getSize() < team1.getCapacity()) {
            team1.add(randomFactoryTeam1.create());
        }
        teams.add(team1);

        Team team2 = teamFactory.create();
        team2.setColor("white");
        RandomFactory randomFactoryTeam2 = new RandomFactory(new HeroFactory[]{
                new CrossbowmanFactory(),
                new MonkFactory(),
                new PeasantFactory(),
                new SpearmanFactory(),
        });
        while (team2.getSize() < team2.getCapacity()) {
            team2.add(randomFactoryTeam2.create());
        }
        teams.add(team2);

        return teams;
    }
}