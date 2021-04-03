package second_semester.diving.models.participant;

import second_semester.diving.inter.Human;
import second_semester.diving.inter.PresentAtTheCompetition;
import second_semester.diving.models.Competition;

import java.util.Random;

public class Judge extends Human implements PresentAtTheCompetition {

    public Judge(String name) {
        super(name);
    }

    @Override
    public int doYourJob(int valueOf, Competition competition) {
        if (competition.getMaxRate()!=0){
            return enotherRate(valueOf, competition);
        }

        //не волнуется
        if (valueOf <= 3) {
            return new Random().nextInt(5)+6;
        }

        //немного
        if (valueOf >= 4 & valueOf < 8) {
            return new Random().nextInt(5)+3;
        }

        //очень
        return new Random().nextInt(3)+1;
    }

    private int enotherRate(int valueOf, Competition c){
        //не волнуется
        if (valueOf <= 3) {
            return new Random().nextInt(c.getMaxRate()+5)+c.getMinRate()+6;
        }

        //немного
        if (valueOf >= 4 & valueOf < 8) {
            return new Random().nextInt(c.getMaxRate()+5)+c.getMinRate()+3;
        }

        //очень
        return new Random().nextInt(c.getMaxRate()+3)+c.getMinRate()+1;
    }


}
