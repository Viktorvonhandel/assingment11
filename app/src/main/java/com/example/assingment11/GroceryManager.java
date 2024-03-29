package com.example.assingment11;
import java.util.ArrayList;

public class GroceryManager {

    private static GroceryManager instance;
    private ArrayList<Grocery> groceries;

    private GroceryManager() {
        groceries = new ArrayList<>();
    }

    public static synchronized GroceryManager getInstance() {
        if (instance == null) {
            instance = new GroceryManager();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public void updateGrocery(int index, Grocery updatedGrocery) {
        if (index >= 0 && index < groceries.size()) {
            groceries.set(index, updatedGrocery);
        }
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }
}

