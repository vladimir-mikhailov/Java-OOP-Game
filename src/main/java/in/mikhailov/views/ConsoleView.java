package in.mikhailov.views;

import in.mikhailov.battle.Battle;
import in.mikhailov.battle.Cell;
import in.mikhailov.groups.Team;
import in.mikhailov.heroes.Hero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ConsoleView {

    public static void printBattleStatus(Battle battle) {

        System.out.println();

        Team team1 = battle.getTeam1();
        Team team2 = battle.getTeam2();
        String[] field = getField(battle);


        String headerFormat = "%-69s";
        String unitNameFormat = "%-19s";
        String unitNameRedFormat = "%-24s";
        String unitClassFormat = "%-15s";
        String unitInfoFormat = "%-43s";
        String unitsRowFormat = (unitNameFormat + unitClassFormat + unitInfoFormat);
        String unitsRowRedFormat = (unitNameRedFormat + unitClassFormat + unitInfoFormat);
        String fieldFormat = "%-38s";

        StringBuilder mainSection = new StringBuilder();
        mainSection.append(String.format(fieldFormat, AnsiColors.ANSI_RED + AnsiColors.ANSI_RESET)); // balance ansi string length

        boolean team1IsRed = team1.getColor().equals("red");
        if (team1IsRed) {
            mainSection.append(AnsiColors.ANSI_RED);
            mainSection.append(String.format(headerFormat, "🚩" + team1.getName()));
            mainSection.append(AnsiColors.ANSI_RESET);
            mainSection.append(String.format(headerFormat, "🏳" + team2.getName()));
        } else {
            mainSection.append(String.format(headerFormat, "🏳️" + team1.getName()));
            mainSection.append(AnsiColors.ANSI_RED);
            mainSection.append(String.format(headerFormat, "🚩" + team2.getName()));
            mainSection.append(AnsiColors.ANSI_RESET);
        }

            mainSection.append("\n");

        mainSection.append(String.format(fieldFormat, field[0]));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        mainSection.append("\n");

        Iterator<Hero> team1Iterator = team1.iterator();
        Iterator<Hero> team2Iterator = team2.iterator();
        int f = 1;
        while (team1Iterator.hasNext() && team2Iterator.hasNext()) {
            if (f%2 != 0) {
                Hero team1Hero = team1Iterator.next();
                Hero team2Hero = team2Iterator.next();
                mainSection.append(String.format(fieldFormat, field[f++]));

                if (team1IsRed) {
                    mainSection.append(AnsiColors.ANSI_RED);
                    mainSection.append(String.format(unitsRowRedFormat, AnsiColors.ANSI_BOLD +  team1Hero.getName() + AnsiColors.ANSI_RESET + AnsiColors.ANSI_RED, team1Hero.getClassName(), team1Hero.getInfo()));
                    mainSection.append(AnsiColors.ANSI_RESET);
                    mainSection.append(String.format(unitsRowFormat, AnsiColors.ANSI_BOLD +  team2Hero.getName() + AnsiColors.ANSI_RESET, team2Hero.getClassName(), team2Hero.getInfo()));
                } else {
                    mainSection.append(String.format(unitsRowFormat, AnsiColors.ANSI_BOLD +   team1Hero.getName() + AnsiColors.ANSI_RESET, team1Hero.getClassName(), team1Hero.getInfo()));
                    mainSection.append(AnsiColors.ANSI_RED);
                    mainSection.append(String.format(unitsRowRedFormat,  AnsiColors.ANSI_BOLD + team2Hero.getName() + AnsiColors.ANSI_RESET + AnsiColors.ANSI_RED, team2Hero.getClassName(), team2Hero.getInfo()));
                    mainSection.append(AnsiColors.ANSI_RESET);
                }


            } else {
                mainSection.append(String.format(fieldFormat, field[f++]));
                mainSection.append(String.format(unitsRowFormat, "", " ", " "));
                mainSection.append(String.format(unitsRowFormat, " ", " ", " "));
            }
            mainSection.append("\n");
        }
        mainSection.append(String.format(fieldFormat, field[21]));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        System.out.println(mainSection);
    }

    private static String[] getField(Battle battle) {
        HashSet<Cell> cells = battle.getBattleField().getCells();

        List<List<Cell>> columns = new ArrayList<>();
        for (int i = 0; i < battle.getBattleField().getWidth(); i++) {
            int finalI = i;
            columns.add(cells.stream().filter(cell -> cell.getX() == finalI).toList());
        }

        String[] field = new String[22];

        String top =     "┌─" + "┬─".repeat(9) + "┐";
        String between = "├─" + "┼─".repeat(9) + "┤";
        String bottom =  "└─" + "┴─".repeat(9) + "┘";

        field[0] =  top;
        int y = 0;
        for (int i = 1; i < 21; i++) {

            if (i%2 == 0) field[i] = between;
            else {
                StringBuilder innerCells = new StringBuilder();
                for (int x = 0; x < 10; x++) {
                    Cell currentCell = columns.get(x).get(y);
                    if (currentCell.getHero() != null) {
                        boolean isRedTeam = currentCell.getHero().getTeam().getColor().equals("red");
                        boolean isDead = currentCell.getHero().getHealth() == 0;
                        innerCells.append(isRedTeam ? AnsiColors.ANSI_RED : "");
                        innerCells.append(isDead? AnsiColors.ANSI_STRIKED : "");
                        innerCells.append(currentCell);
                        innerCells.append(AnsiColors.ANSI_RESET);

                    } else {
                        innerCells.append(currentCell);
                    }
                    if (x!=9) innerCells.append("│");
                }

                field[i] =  "│"  + innerCells + "│" + " ".repeat(8);
                y++;
            }

        }
        field[21] = bottom;

        return field;
    }

    public static void printRoundReport() {

    }

    public static void printMenu(String type) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (type) {
            case "start" -> stringBuilder.append("Start Battle");
            case "nextRound" -> stringBuilder.append("Next Round");
        }
        stringBuilder.append(" – <Enter>, Exit – <Q>: ");
        System.out.print(stringBuilder);
    }

}

