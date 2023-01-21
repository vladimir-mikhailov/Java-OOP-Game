package in.mikhailov.heroes;

public class RoqueFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Roque();
    }
}
