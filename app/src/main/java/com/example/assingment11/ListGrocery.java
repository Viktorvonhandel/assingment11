package com.example.assingment11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListGrocery {
    private static ListGrocery instance;
    private ArrayList<Grocery> groceries;

    private ListGrocery() {
        groceries = new ArrayList<>();
    }

    public static ListGrocery getInstance() {
        if (instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public void removeGrocery(String name) {
        Grocery groceryToRemove = null;
        for (Grocery grocery : groceries) {
            if (grocery.getName().equals(name)) {
                groceryToRemove = grocery;
                break;
            }
        }
        if (groceryToRemove != null) {
            groceries.remove(groceryToRemove);
        }
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceries) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null; // Palautetaan null, jos ei löydy ruokakauppaa annetulla nimellä
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceries, (g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
    }

    public void sortGroceriesByTime() {
        // Lisää aikajärjestykseen järjestämisen toiminnallisuus tarvittaessa
    }
}
