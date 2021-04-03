package second_semester.oop.model;


import second_semester.oop.inter.Grass;

public class Mint extends Grass {

    private String description;

    public Mint(int height, int growthSpeed, String description) {
        super(height, growthSpeed);
        this.description = description;
    }
    @Override
    public void aboutMe() {
        return description +
                ", я выростаю на " + getMaxHeight() +
                " метров, а расту я со скоростью "+ getGrowthSpeed() + " мм в сутки "+"\n"
                + rapidGrowth()+"\n"+
                absorbCD()+"\n"+reproduce()
                ;
    }
}
