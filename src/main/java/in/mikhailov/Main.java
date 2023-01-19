package in.mikhailov;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        RandomFactory randomFactory1 = new RandomFactory(new HeroFactory[]{
                new PeasantFactory(),
                new RoqueFactory(),
                new SniperFactory(),
                new WizardFactory()
        });

        RandomFactory randomFactory2 = new RandomFactory(new HeroFactory[]{
                new CrossbowmanFactory(),
                new MonkFactory(),
                new PeasantFactory(),
                new SpearmanFactory(),
        });

        int partyCapacity = 10;
        ArrayList<Hero> heroesParty1 = new ArrayList<>(partyCapacity);
        ArrayList<Hero> heroesParty2 = new ArrayList<>(partyCapacity);
        heroesParty1.add(new WizardFactory().create());
        heroesParty2.add(new MonkFactory().create());

        Random rnd = new Random();
        for (int i = 0; i < partyCapacity - 1; i++) {
            Hero hero1 = randomFactory1.create();
            if (!hero1.getClass().getName().contains("Peasant")) {
                hero1.setHealth(rnd.nextInt(1, hero1.getMaxHealth()));
            }
            heroesParty1.add(hero1);

            Hero hero2 = randomFactory2.create();
            if (!hero2.getClass().getName().contains("Peasant")) {
                hero2.setHealth(rnd.nextInt(1, hero2.getMaxHealth()));
            }
            heroesParty2.add(hero2);
        }

        System.out.println("Party1 heroes:");
        heroesParty1.forEach(hero -> System.out.println(hero.getInfo()));

        System.out.println("\nParty 1 actions:");
        for (int i = 0; i < 5; i++) {
            heroesParty1.get(0).step(heroesParty1);
        }

        System.out.println("\nParty2 heroes:");
        heroesParty2.forEach(hero -> System.out.println(hero.getInfo()));

        System.out.println("\nParty 2 actions:");
        for (int i = 0; i < 5; i++) {
            heroesParty2.get(0).step(heroesParty2);
        }

//        ArrayList<Hero> filteredList = filter("Wizard", heroes);
//
//        System.out.println("\nWizards:");
//        for (Hero hero : filteredList) {
//            System.out.println(hero);
//        }
    }

    public static ArrayList<Hero> filter(String className, ArrayList<Hero> heroes) {
        ArrayList<Hero> result = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getClass().getName().equals(Hero.class.getPackageName() + "." + className)) {
                result.add(hero);
            }
        }
        return result;
    }
}