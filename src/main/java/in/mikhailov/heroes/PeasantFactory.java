package in.mikhailov.heroes;

public class PeasantFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Peasant();
    }
}
