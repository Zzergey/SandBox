package second_semester.oop.inter;

public abstract class Animal implements Life{

    protected String move() {
        return "Общее от предка 'Animal' у меня то, что я умею двигаться";
    };

    @Override
    public String reproduce() {
        return "Общее от предка Life у меня то, что я умею размножаться";
    }

}
