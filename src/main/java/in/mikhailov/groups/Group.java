package in.mikhailov.groups;

import in.mikhailov.heroes.Hero;

import java.util.*;

abstract class Group implements GroupInterface, Iterator<Hero>, Iterable<Hero> {
    protected List<Hero> group;
    int capacity;
    int index;

    public Group() {
        group = new ArrayList<>();
        index = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return group.size();
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
        hero.setTeam(group);
        return true;
    }

    @Override
    public void remove(Hero hero) {
        group.remove(hero);
    }

    @Override
    public boolean hasNext() {
        if (index < capacity) {
            return true;
        }
        index = 0;
        return false;
    }

    @Override
    public Hero next() {
        return group.get(index++);
    }

    @Override
    public Iterator<Hero> iterator() {
        return group.iterator();
    }
}
