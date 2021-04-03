package second_semester.oop.model;


import second_semester.oop.inter.Herbivore;

public class FlyingFox extends Herbivore {

    private String description;

    public FlyingFox(int lifeLong, String liveOn, String description) {
        super(lifeLong, liveOn);
        this.description = description;
    }

    @Override
    public void aboutMe() {
        return description +
                ", я живу около " + getLifeLong() +
                " лет, и предпочитаю жить "+ getLiveOn()+"\n"+
                move()+ "\n"+
                graze()+"\n"+reproduce();
    }
}
