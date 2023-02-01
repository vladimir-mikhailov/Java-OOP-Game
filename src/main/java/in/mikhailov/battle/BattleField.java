package in.mikhailov.battle;

import java.util.HashMap;
import java.util.HashSet;

public class BattleField {
    private final int height = 10;
    private final int width = 10;
    private final HashSet<Cell> cells;

    public BattleField() {
        cells = createCells();
        setAdjacentCells();
    }

    private void setAdjacentCells() {
        for (Cell cell: this.cells) {
            HashMap<Enum<?>, Cell> adjacentCells = new HashMap<>(4);
            int x = cell.getX();
            int y = cell.getY();
            Cell upperCell = new Cell(x, y + 1);
            Cell rightCell = new Cell(x + 1, y);
            Cell lowerCell = new Cell(x, y - 1);
            Cell leftCell = new Cell(x - 1, y);

            if (cells.contains(upperCell)) {
                for (Cell c: cells) {
                    if (c.equals(upperCell)) adjacentCells.put(Direction.UP, c);
                    if (c.equals(rightCell)) adjacentCells.put(Direction.RIGHT, c);
                    if (c.equals(lowerCell)) adjacentCells.put(Direction.DOWN, c);
                    if (c.equals(leftCell)) adjacentCells.put(Direction.LEFT, c);
                }
            }
            cell.setAdjacentCells(adjacentCells);
        }
    }

    private HashSet<Cell> createCells() {
        HashSet<Cell> cells = new HashSet<>(height * width);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.add(new Cell(x, y));
            }
        }
        return cells;
    }

    public HashSet<Cell> getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
