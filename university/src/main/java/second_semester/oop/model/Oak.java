package second_semester.oop.model;


import second_semester.oop.inter.Tree;

public class Oak extends Tree {

    private String description;

    public Oak(int height, String type, String description) {
        super(height, type);
        this.description = description;
    }

    @Override
    public void aboutMe() {
        return description +
                ", я выростаю на " + getMaxHeight() +
                " метров, и я "+ getType() + " дерево "+"\n"
                +absorbCD() + "\n" +
                reproduce()+"\n"+ growTaller();
    }
}
