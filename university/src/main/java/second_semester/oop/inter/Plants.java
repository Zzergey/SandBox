package second_semester.oop.inter;

public abstract class Plants implements Life{

    protected String absorbCD(){
        return "Общее от предка Plants у меня то, что я умею поглощать кислород";
    };

    @Override
    public String reproduce() {
        return "Общее от предка Life у меня то, что я умею размножаться";
    }

}
