package in.mikhailov;

public class SniperFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Sniper();
    }
}
