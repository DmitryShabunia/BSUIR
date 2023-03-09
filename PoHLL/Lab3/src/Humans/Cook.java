package Humans;

import Enums.Taste;
import Items.Food;
import Items.Veget;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Random;

public class Cook {
    public Cook() {
        super();
    }

    public Cook (String name) {

    }

    public void cook (ArrayList<Food> fl, String name, Veget veget) {
        int rand = new Random().nextInt(4);
        Food f = new Food(name);
        switch (rand) {
            case 0: f.setTaste(Taste.SWEET); break;
            case 1: f.setTaste(Taste.SOUR); break;
            case 2: f.setTaste(Taste.SALTY); break;
            case 3: f.setTaste(Taste.BITTER); break;
        }
        f.setVeget(veget);
        fl.add (fl.size(), f);
    }
}
