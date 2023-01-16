package in.mikhailov;

public class WizardFactory implements HeroFactory{
    @Override
    public Hero create() {
        return new Wizard();
    }
}
