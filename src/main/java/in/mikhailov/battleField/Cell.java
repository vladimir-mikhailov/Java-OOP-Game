package in.mikhailov.battleField;

import in.mikhailov.heroes.Hero;

public class Cell {
    private final int X;
    private final int Y;
    private Hero hero;

    public Cell(int x, int y, Hero hero) {
        this.X = x;
        this.Y = y;
        this.hero = hero;
    }

    public Cell(int x, int y) {
        this(x, y, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (X != cell.X) return false;
        return Y == cell.Y;
    }

    @Override
    public String toString() {
        return hero == null ? " " : hero.getClassName().substring(0, 1);
    }

    @Override
    public int hashCode() {
        int result = X;
        result = 31 * result + Y;
        return result;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
