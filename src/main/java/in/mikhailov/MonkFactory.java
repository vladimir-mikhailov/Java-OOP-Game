package in.mikhailov;

public class MonkFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Monk();
    }
}
