package in.mikhailov.groups;

public class TeamFactory implements GroupFactory{
    @Override
    public Team create() {
        return new Team();
    }
}
