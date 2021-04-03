package second_semester.oop.inter;

public abstract class Trees extends Tree {

    private final int maxHeight;
    private final String type;

    public Trees(int height, String type, int maxHeight, String type1) {
        super(height, type);
        this.maxHeight = maxHeight;
        this.type = type1;
    }

    @Override
    public void aboutMe() {
        reproduce();
        absorbCD();
        growTaller();
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String getType() {
        return type;
    }

}
