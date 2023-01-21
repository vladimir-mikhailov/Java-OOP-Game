package in.mikhailov.heroes;

public class CrossbowmanFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Crossbowman();
    }
}
