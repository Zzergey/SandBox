package second_semester.oop.model;


import second_semester.oop.inter.Predator;

public class Owl extends Predator {

    private String description;

    public Owl(int lifeLong, String timeOfDayActive, String description) {
        super(lifeLong, timeOfDayActive);
        this.description = description;
    }

    @Override
    public void aboutMe() {
        return description +
                ", я активен " + getTimeOfDayActive() +
                ", а живу примерно "+ getLifeLong() + " лет"+"\n"
                +hunt()+"\n" +move()+"\n"+reproduce();
    }
}
