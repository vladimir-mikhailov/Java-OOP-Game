package in.mikhailov.heroes;

public class WizardFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Wizard();
    }
}
