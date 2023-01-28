package in.mikhailov.battle;

import in.mikhailov.groups.Team;
import in.mikhailov.heroes.Hero;
import in.mikhailov.views.AnsiColors;

import java.util.List;

public class Battle {
    private int round;
    private Team winner;
    private final Team team1;
    private final Team team2;
    private final BattleField battleField;

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
        List<Cell> leftColumn = battleField.getCells().stream().filter(cell -> cell.getX() == 0).toList();
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

        if (team1.getColor().equals("red")) System.out.print(AnsiColors.ANSI_RED);
        team1.makeMove();
        if (team1.getColor().equals("red")) System.out.print(AnsiColors.ANSI_RESET);

        team2.makeMove();

        if (team1.getHeroes().stream().noneMatch(hero -> hero.getHealth() > 0)) setWinner(team2);
        else if (team2.getHeroes().stream().noneMatch(hero -> hero.getHealth() > 0)) setWinner(team1);

        round++;
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
