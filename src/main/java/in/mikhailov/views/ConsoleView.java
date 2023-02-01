package in.mikhailov.views;

import in.mikhailov.battle.Battle;
import in.mikhailov.battle.Cell;
import in.mikhailov.groups.Team;
import in.mikhailov.heroes.Hero;

import java.util.*;

public class ConsoleView {

    public static void printBattleStatus(Battle battle) {

        System.out.println();

        Team team1 = battle.getTeam1();
        Team team2 = battle.getTeam2();
        String[] field = getField(battle);

        String headerFormat = "%-73s";
        String unitNameFormat = "%-15s";
        String unitNameRedFormat = AnsiColors.STYLE_BOLD + unitNameFormat + AnsiColors.RESET + AnsiColors.RED;
        String unitClassFormat = "%-15s";
        String unitInfoFormat = "%-43s";
        String unitsRowFormat = (unitNameFormat + unitClassFormat + unitInfoFormat);
        String unitsRowRedFormat = (unitNameRedFormat + unitClassFormat + unitInfoFormat);
        String fieldFormat = "%-31s";

        StringBuilder mainSection = new StringBuilder();
        mainSection.append(String.format(fieldFormat, ""));

        mainSection.append(AnsiColors.RED);
        mainSection.append(String.format(headerFormat, "🚩" + team1.getName()));
        mainSection.append(AnsiColors.RESET);
        mainSection.append(String.format(headerFormat, "🏳" + team2.getName()));

        mainSection.append("\n");

        mainSection.append(String.format(fieldFormat, field[0]));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        mainSection.append(String.format(unitsRowFormat, "", "", ""));
        mainSection.append("\n");

        Iterator<Hero> team1Iterator = team1.iterator();
        Iterator<Hero> team2Iterator = team2.iterator();
        int f = 1;
        while (team1Iterator.hasNext() && team2Iterator.hasNext()) {
            if (f % 2 != 0) {
                Hero team1Hero = team1Iterator.next();
                Hero team2Hero = team2Iterator.next();
                String fieldFormatCurrent = "%-" + (field[f].length() + 10) +"s";
                mainSection.append(String.format(fieldFormatCurrent, field[f]));
//                mainSection.append(field[f].length());
                f++;

                mainSection.append(AnsiColors.RED);
                mainSection.append(String.format(unitsRowRedFormat, team1Hero.getName(), team1Hero.getClassName(), team1Hero.getInfo()));
                mainSection.append(AnsiColors.RESET);

                mainSection.append(String.format(unitsRowFormat, team2Hero.getName(), team2Hero.getClassName(), team2Hero.getInfo()));

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
            columns.add(
                    cells.stream()
                            .filter(cell -> cell.getX() == finalI)
                            .sorted(Comparator.comparing(Cell::getY))
                            .toList()
            );
        }

        String[] field = new String[22];

        String top = "┌─" + "┬─".repeat(9) + "┐";
        String between = "├─" + "┼─".repeat(9) + "┤";
        String bottom = "└─" + "┴─".repeat(9) + "┘";

        field[0] = top;
        int y = 0;
        for (int i = 1; i < 21; i++) {

            if (i % 2 == 0) field[i] = between;
            else {
                StringBuilder innerCells = new StringBuilder();
                for (int x = 0; x < 10; x++) {
                    Cell currentCell = columns.get(x).get(y);
                    if (currentCell.getHero() != null) {
                        boolean isRedTeam = currentCell.getHero().getTeam().getColor().equals("red");
                        String format = isRedTeam ? AnsiColors.RED + "%1c" + AnsiColors.RESET : "%1c";
                        innerCells.append(String.format(format, currentCell.getHero().getClassName().charAt(0)));
                    } else if (currentCell.getDeadHeroes() != null) {
                        Hero lastDeadHero = currentCell.getLastDeadHero();
                        boolean isRedTeam = lastDeadHero.getTeam().getColor().equals("red");
                        String format = isRedTeam ? AnsiColors.RED + AnsiColors.STYLE_STRIKED + "%1c" + AnsiColors.RESET : AnsiColors.STYLE_STRIKED + "%1c" + AnsiColors.RESET;
                        innerCells.append(String.format(format, lastDeadHero.getClassName().charAt(0)));
                    } else {
                        innerCells.append(" ");
                    }
                    if (x != 9) innerCells.append("│");
                }

                field[i] = "│" + innerCells + "│";

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
            case "newBattle" -> stringBuilder.append("New Battle");
        }
        stringBuilder.append(" – <Enter>, Exit – <Q>: ");
        System.out.print(stringBuilder);
    }

}

