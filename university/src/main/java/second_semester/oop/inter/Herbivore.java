package second_semester.oop.inter;

public abstract class Herbivore extends Animal {

    private final int lifeLong;
    private final String liveOn;

    public Herbivore(int lifeLong, String liveOn) {
        this.lifeLong = lifeLong;
        this.liveOn = liveOn;
    }

    public int getLifeLong() {
        return lifeLong;
    }

    public String getLiveOn() {
        return liveOn;
    }

    protected String graze(){
        return "Общее от предка Herbivore у меня то, что я умею пастись";
    };



}
