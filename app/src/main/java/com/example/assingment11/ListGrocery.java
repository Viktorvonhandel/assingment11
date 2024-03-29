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

    public void removeGrocery(int position) {
        groceries.remove(position);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceries, (g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
    }

    public void sortGroceriesByTime() {
        // Olettaen, että jokaisella Grocery-oliolla on aikaleimaominaisuus, joka edustaa aikaa
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery g1, Grocery g2) {
                // Toteuta logiikka ostosten vertailuun ajan perusteella
                // Esimerkiksi:
                // return g1.getTimestamp().compareTo(g2.getTimestamp());
                // Korvaa getTimestamp() todellisella metodilla aikaleiman hakemiseksi ostokselta
                // Tämä on vain paikantäyttöarvo, joka tulee korvata todellisella toteutuksella
                return 0; // Paikantäyttöarvo
            }
        });
    }
}
