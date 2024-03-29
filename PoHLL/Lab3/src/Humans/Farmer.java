package Humans;

import Items.Food;
import Items.Veget;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Farmer {

    private int planted;
    private int watered;
    private ArrayList<Veget> vegetable = new ArrayList<Veget>();

    public int getVegetSize() {
        return vegetable.size();
    }

    public int getPlanted() {
        return planted;
    }

    public int getWatered() {
        return watered;
    }

    public Farmer () {
        super();
        planted = 0;
        watered = 0;
    }

    public Farmer (String name) {
        planted = 0;
        watered = 0;
    }

    public void plant() {
        planted++;
    }

    public void water() {
        if (planted > 0) {
            planted--;
            watered++;
        }
    }

    public void collect () {
        if (watered > 0) {
            watered--;
            Veget veget = new Veget();
            veget.setRandVeget();
            veget.setName("Enums.Vegetable");
            vegetable.add(veget);
        }
    }

    public Veget getLast() {
        return vegetable.get(vegetable.size()-1);
    }

    public void deleteVeget() {
        vegetable.remove(vegetable.size()-1);
    }
}