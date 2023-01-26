package in.mikhailov.groups;

import in.mikhailov.heroes.Hero;

import java.util.*;
import com.github.javafaker.Faker;

abstract class Group implements GroupInterface, Iterable<Hero> {
    protected List<Hero> group;
    int capacity;
    int index;
    String name;


    public Group(String name) {
        group = new ArrayList<>();
        index = 0;
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

    public int getSize() {
        return group.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sort(String sortBy) {
        Comparator<Hero> comparator = null;
        switch (sortBy) {
            case "className" -> comparator = Comparator.comparing(Hero::getClassName);
            case "healthPoints" -> comparator = Comparator.comparing(Hero::getHealth);
        }
        group.sort(comparator);
    }
    @Override
    public boolean add(Hero hero) {
        group.add(hero);
        return true;
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
