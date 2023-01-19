package in.mikhailov;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        RandomFactory randomFactory = new RandomFactory(new HeroFactory[]{
                new CrossbowmanFactory(),
                new MonkFactory(),
                new PeasantFactory(),
                new RoqueFactory(),
                new SniperFactory(),
                new SpearmanFactory(),
                new WizardFactory()
        });

        ArrayList<Hero> heroes = new ArrayList<>(50);

        for (int i = 0; i < 50; i++) {
            heroes.add(randomFactory.create());
        }

        heroes.forEach(System.out::println);

        ArrayList<Hero> filteredList = filter("Wizard", heroes);

        System.out.println("\nWizards:");
        for (Hero hero : filteredList) {
            System.out.println(hero);
        }
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