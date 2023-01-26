package in.mikhailov.battleField;

import java.util.HashSet;

public class BattleField {
    private final int height = 10;
    private final int width = 10;
    private final HashSet<Cell> cells;

    public BattleField() {
        cells = createCells();
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
