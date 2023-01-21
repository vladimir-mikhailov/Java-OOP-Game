package in.mikhailov.heroes;

public class SpearmanFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Spearman();
    }
}
