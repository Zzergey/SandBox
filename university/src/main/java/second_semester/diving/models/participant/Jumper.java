package second_semester.diving.models.participant;


import second_semester.diving.inter.Human;
import second_semester.diving.inter.PresentAtTheCompetition;
import second_semester.diving.models.Competition;

public class Jumper extends Human implements PresentAtTheCompetition {

    private final int id;

    public Jumper(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public int doYourJob(int valueOf, Competition competition) {
        return valueOf;
    }

    public int getId() {
        return id;
    }

}
