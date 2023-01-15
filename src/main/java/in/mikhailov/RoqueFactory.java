package in.mikhailov;

public class RoqueFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Roque();
    }
}
