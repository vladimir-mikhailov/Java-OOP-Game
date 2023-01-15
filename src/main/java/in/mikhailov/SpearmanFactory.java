package in.mikhailov;

public class SpearmanFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Spearman();
    }
}
