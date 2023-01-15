package in.mikhailov;

public class PeasantFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Peasant();
    }
}
