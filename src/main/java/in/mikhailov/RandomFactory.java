package in.mikhailov;

import java.util.Random;

public class RandomFactory implements HeroFactory{
    HeroFactory[] factories;
    Random r = new Random();

    public RandomFactory(HeroFactory[] factories) {
        this.factories = factories;
    }

    @Override
    public Hero create() {
        int ind = r.nextInt(factories.length);
        return factories[ind].create();
    }
}
