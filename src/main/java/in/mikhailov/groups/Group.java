package in.mikhailov.groups;

import in.mikhailov.heroes.Hero;

import java.util.*;
import com.github.javafaker.Faker;

abstract class Group implements GroupInterface, Iterable<Hero> {
    protected List<Hero> group;
    int capacity;
    String name;


    public Group(String name) {
        group = new ArrayList<>();
        this.name = name;
    }

    public Group() {
        this((new Faker()).lordOfTheRings().location());
    }

    public List<Hero> getHeroes() {
        return group;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return group.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Hero hero) {
        group.add(hero);
    }

    @Override
    public void remove(Hero hero) {
        group.remove(hero);
    }

    @Override
    public Iterator<Hero> iterator() {
        return group.iterator();
    }
}
