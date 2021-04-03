package OOP;


import second_semester.oop.inter.Life;
import second_semester.oop.model.*;

import java.util.ArrayList;

public class OOPStart {

    public static void main(String[] args) {
        ArrayList<Life> lifeList = new ArrayList<>();
        lifeList.add(new Bamboo(25, 2000, "Привет! Я бамбук"));
        lifeList.add(new Mint(1, 20, "Привет! Я мята"));
        lifeList.add(new Oak(20, "Лиственное", "Привет! Я дуб"));
        lifeList.add(new Fir(50, "Хвойное", "Привет! Я ель"));
        lifeList.add(new Wolf(17, "днем", "Привет! Я волк"));
        lifeList.add(new Owl(10, "ночью", "Привет! Я сова"));
        lifeList.add(new Cow(18, "на земле", "Привет! Я корова"));
        lifeList.add(new FlyingFox(15, "в воздухе", "Привет! Я летучая лисица"));

        for (Life c: lifeList ) {
            System.out.println( c.aboutMe() );
            System.out.println("------------------------------------------------------");
        }
    }


}
