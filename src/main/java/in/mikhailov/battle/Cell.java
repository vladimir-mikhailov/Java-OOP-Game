package in.mikhailov.battle;

import in.mikhailov.heroes.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cell {
    private final int X;
    private final int Y;
    private Hero hero;
    private List<Hero> deadHeroes;
    private HashMap<Enum<?>, Cell> adjacentCells;

    public Cell(int x, int y) {
        this.X = x;
        this.Y = y;
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

    public List<Hero> getDeadHeroes() {
        return deadHeroes;
    }

    public void addDeadHero(Hero deadHero) {
        if (deadHeroes == null) deadHeroes = new ArrayList<>(1);
        deadHeroes.add(deadHero);
    }

    public Hero getLastDeadHero() {
        return deadHeroes.get(deadHeroes.size() - 1);
    }

    public HashMap<Enum<?>, Cell> getAdjacentCells() {
        return adjacentCells;
    }

    public void setAdjacentCells(HashMap<Enum<?>, Cell> adjacentCells) {
        this.adjacentCells = adjacentCells;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
