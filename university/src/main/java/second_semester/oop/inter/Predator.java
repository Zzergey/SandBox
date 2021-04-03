package second_semester.oop.inter;

public abstract class Predator extends Animal{

    private final int lifeLong;
    private final String timeOfDayActive;

    public Predator(int lifeLong, String timeOfDayActive) {
        this.lifeLong = lifeLong;
        this.timeOfDayActive = timeOfDayActive;
    }

    public int getLifeLong() {
        return lifeLong;
    }

    public String getTimeOfDayActive() {
        return timeOfDayActive;
    }

    protected String hunt(){
        return "Общее от предка Predator у меня то, что я умею охотится";
    };

}
