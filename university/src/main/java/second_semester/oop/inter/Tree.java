package second_semester.oop.inter;

public abstract class Tree extends Plants{

    private final int maxHeight;
    private final String type;

    public Tree(int height, String type) {
        this.maxHeight = height;
        this.type = type;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String getType() {
        return type;
    }

    protected String growTaller(){
        return "Общее от предка Tree у меня то, что я умею выростать очень большим";
    };

}
