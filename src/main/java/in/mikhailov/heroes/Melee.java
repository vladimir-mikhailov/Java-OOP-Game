package in.mikhailov.heroes;

import in.mikhailov.battle.Cell;
import in.mikhailov.battle.Direction;

import java.util.HashMap;

public abstract class Melee extends Hero {
    public Melee(int attack, int defense, int[] damage, int maxHealth, int speed, String name) {
        super(attack, defense, damage, maxHealth, speed, name);
    }

    @Override
    public void step() {
        if (health == 0) return;

        HashMap<Hero, Float> nearestOpponent = getNearestOpponent();
        Hero opponentHero = nearestOpponent.keySet().stream().toList().get(0);
        float distance = nearestOpponent.values().stream().toList().get(0);

        if (distance < 2) {
            float damageAmount;
            if (opponentHero.getDefense() < this.getDefense()) {
                damageAmount = this.getDamage()[1];
            } else if (opponentHero.getDefense() == this.getDefense()) {
                damageAmount = (this.getDamage()[0] + this.getDamage()[1]) / 2.0f;
            } else {
                damageAmount = this.getDamage()[0];
            }
            System.out.println(className + " " + name +
                    " hits 🗡️ " + opponentHero.getClassName() + " " + opponentHero.getName() +
                    " 👊" + (int) damageAmount);
            opponentHero.takeDamage(damageAmount);
        } else {
            Direction direction = getNextMoveDirection(opponentHero);
            Cell targetCell = this.getCell().getAdjacentCells().get(direction);
            if (direction != null && targetCell != null) {
                System.out.println(className + " " + name + " goes " + direction.name() +
                        " from [" + getCell().getX() + ":" + getCell().getY() + "]" +
                        " to [" + targetCell.getX() + ":" + targetCell.getY() + "]");
                move(direction);
            }
        }


    }


}
