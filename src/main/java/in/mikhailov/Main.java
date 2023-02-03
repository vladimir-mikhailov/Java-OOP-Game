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
        startBattle();
    }


    public static void startBattle() {
        List<Team> teams = getTeams();
        team1 = teams.get(0);
        team2 = teams.get(1);
        BattleField battleField = new BattleField();
        battle = new Battle(team1, team2, battleField);

        ConsoleView.printBattleStatus(battle);
        System.out.println();
        ConsoleView.printMenu("start");

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            if (input.nextLine().isEmpty()) {
                if (battle.getWinner() == null) battle.nextRound();
                else startBattle();

                ConsoleView.printRoundReport();
                ConsoleView.printBattleStatus(battle);
                System.out.println();

                if (battle.getWinner() == null) ConsoleView.printMenu("nextRound");
                else {
                    Team winner = battle.getWinner();
                    boolean isRed = winner.getColor().equals("red");
                    if (isRed) System.out.print(AnsiColors.RED);
                    System.out.println(winner.getName() + " won 🎖️");
                    if (isRed) System.out.print(AnsiColors.RESET);

                    ConsoleView.printMenu("newBattle");
                }
            } else break;
        }
    }

    public static List<Team> getTeams() {
        List<Team> teams = new ArrayList<>(2);

        Team team1 = new Team("red");
        team1.setRandomFactory(new RandomFactory(new HeroFactory[]{
                new PeasantFactory(),
                new RoqueFactory(),
                new SniperFactory(),
                new WizardFactory()
        }));

        while (team1.getSize() < team1.getCapacity()) {
            team1.add(team1.getRandomFactory().create());
        }
        teams.add(team1);

        Team team2 = new Team("white");
        team2.setRandomFactory(new RandomFactory(new HeroFactory[]{
                new CrossbowmanFactory(),
                new MonkFactory(),
                new PeasantFactory(),
                new SpearmanFactory(),
        }));
        while (team2.getSize() < team2.getCapacity()) {
            team2.add(team2.getRandomFactory().create());
        }
        teams.add(team2);

        return teams;
    }
}