package in.mikhailov.heroes;

public class MonkFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Monk();
    }
}
