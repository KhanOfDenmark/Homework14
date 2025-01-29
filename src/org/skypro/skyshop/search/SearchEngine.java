package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;

public class SearchEngine {
    static ArrayList<Searchable> objects = new ArrayList<>();

    public static ArrayList<Searchable> search(String term) {
        ArrayList<Searchable> discovered = new ArrayList<>();
        for (Searchable object:objects) {
            if (object.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                discovered.add(object);
            }
        }
        return discovered;
    }

    public static void add(Searchable object) {
        objects.add(object);
    }

    public static Searchable findBestResult(String search)
    throws BestResultNotFound {
        Searchable object = null;
        int objectValue = 0;
        for (Searchable searchable : objects) {
            int value = 0;
            int index = 0;
            int substringIndex = searchable.getSearchTerm().indexOf(search, index);

            while (substringIndex != -1) {
                value++;
                index = substringIndex + search.length();
                substringIndex = searchable.getSearchTerm().indexOf(search, index);
            }

            if (value > objectValue) {
                object = searchable;
            }
        }
        if (object == null) {
            throw new BestResultNotFound("По запросу \"" + search + "\" ничего не найдено!");
        }
        return object;
    }
}
