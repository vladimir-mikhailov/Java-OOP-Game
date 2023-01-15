package in.mikhailov;

public class CrossbowmanFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Crossbowman();
    }
}
