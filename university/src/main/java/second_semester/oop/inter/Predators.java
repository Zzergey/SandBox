package second_semester.oop.inter;

public abstract class Predators extends Predator {

    private final int lifeLong;
    private final String timeOfDayActive;

    public Predators(int lifeLong, String timeOfDayActive, int lifeLong1, String timeOfDayActive1) {
        super(lifeLong, timeOfDayActive);
        this.lifeLong = lifeLong1;
        this.timeOfDayActive = timeOfDayActive1;
    }

    public int getLifeLong() {
        return lifeLong;
    }

    public String getTimeOfDayActive() {
        return timeOfDayActive;
    }

    @Override
    public void aboutMe() {
        reproduce();
        hunt();
        move();
    }
}
