package in.mikhailov.heroes;

import java.util.List;

public interface HeroInterface {
    String getInfo();
    void step();
    void setTeam(List<Hero> team);
}
