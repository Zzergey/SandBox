package second_semester.oop.inter;

public abstract class Grass extends Plants{

    private final int maxHeight;
    private final int growthSpeed;

    public Grass(int height, int growthSpeed) {
        this.maxHeight = height;
        this.growthSpeed = growthSpeed;
    }

    protected String rapidGrowth() {
        return "Общее от предка 'Grass' у меня то, что я умею быстро расти";
    };

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getGrowthSpeed() {
        return growthSpeed;
    }


}
