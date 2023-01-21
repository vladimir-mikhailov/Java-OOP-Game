package in.mikhailov.heroes;

public class SniperFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Sniper();
    }
}
