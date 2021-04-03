package second_semester.oop.inter;

public abstract class Herbivores extends Herbivore {

    private final int lifeLong;
    private final String liveOn;

    public Herbivores(int lifeLong, String liveOn, int lifeLong1, String liveOn1) {
        super(lifeLong, liveOn);
        this.lifeLong = lifeLong1;
        this.liveOn = liveOn1;
    }

    public int getLifeLong() {
        return lifeLong;
    }

    public String getLiveOn() {
        return liveOn;
    }

    @Override
    public void aboutMe() {
        reproduce();
        graze();
        move();
    }
}
