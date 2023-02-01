package in.mikhailov.battle;

import in.mikhailov.groups.Team;
import in.mikhailov.heroes.Hero;
import in.mikhailov.views.AnsiColors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Battle {
    private final Team team1;
    private final Team team2;
    private final BattleField battleField;
    private int round;
    private Team winner;

    public Battle(Team team1, Team team2, BattleField battleField) {
        this.round = 1;
        this.team1 = team1;
        this.team2 = team2;
        this.team1.setOpponentTeam(team2);
        this.team2.setOpponentTeam(team1);
        this.battleField = battleField;
        arrangeTeams();
    }

    void arrangeTeams() {
        List<Cell> leftColumn = battleField.getCells().stream()
                .filter(cell -> cell.getX() == 0)
                .sorted(Comparator.comparing(Cell::getY))
                .toList();
        List<Hero> leftTeam = team1.getHeroes();
        int y = 0;
        while (y < battleField.getHeight()) {
            Hero currentHero = leftTeam.get(y);
            Cell currentCell = leftColumn.get(y);
            currentCell.setHero(currentHero);
            currentHero.setCell(currentCell);
            y++;
        }

        List<Cell> rightColumn = battleField.getCells().stream().filter(cell -> cell.getX() == battleField.getWidth() - 1).toList();
        List<Hero> rightTeam = team2.getHeroes();
        y = 0;
        while (y < battleField.getHeight()) {
            Hero currentHero = rightTeam.get(y);
            Cell currentCell = rightColumn.get(y);
            currentCell.setHero(currentHero);
            currentHero.setCell(currentCell);
            y++;
        }
    }

    public void nextRound() {
        System.out.println("\n" + "Round " + getRound());

        List<Hero> liveHeroes = new ArrayList<>();
        team1.getHeroes().forEach(hero -> {
            if (hero.getHealth() > 0) liveHeroes.add(hero);
        });
        team2.getHeroes().forEach(hero -> {
            if (hero.getHealth() > 0) liveHeroes.add(hero);
        });
        liveHeroes.sort(Comparator.comparing(Hero::getSpeed,Comparator.reverseOrder()));

        for (Hero hero: liveHeroes) {
            if (hero.getHealth() > 0) {
                boolean isRed = hero.getTeam().getColor().equals("red");
                if (isRed) System.out.print(AnsiColors.RED);
                hero.step();
                if (isRed) System.out.print(AnsiColors.RESET);
            }
            if (isGameOver()) break;
        }

        round++;
    }

    private boolean isGameOver() {
        Team winner = null;
        if (team1.getHeroes().stream().noneMatch(hero -> hero.getHealth() > 0)) winner = team2;
        else if (team2.getHeroes().stream().noneMatch(hero -> hero.getHealth() > 0)) winner = team1;
        if (winner != null) {
            setWinner(winner);
            return true;
        }
        return false;
    }


    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public int getRound() {
        return round;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public BattleField getBattleField() {
        return battleField;
    }
}
