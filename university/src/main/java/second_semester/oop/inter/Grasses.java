package second_semester.oop.inter;

public abstract class Grasses extends Grass {

    private final int maxHeight;
    private final int growthSpeed;

    public Grasses(int height, int growthSpeed, int maxHeight, int growthSpeed1) {
        super(height, growthSpeed);
        this.maxHeight = maxHeight;
        this.growthSpeed = growthSpeed1;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getGrowthSpeed() {
        return growthSpeed;
    }

    @Override
    public void aboutMe() {
        reproduce();
        absorbCD();
        rapidGrowth();
    }
}
