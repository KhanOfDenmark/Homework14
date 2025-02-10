package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.TreeMap;

public class SearchEngine {
    static ArrayList<Searchable> objectsMap = new ArrayList<>();

    public static TreeMap<String, ArrayList<Searchable>> search(String term) {
        TreeMap<String, ArrayList<Searchable>> discovered = new TreeMap<>();

        for (Searchable searched : objectsMap) {
            if (searched.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                ArrayList<Searchable> products = new ArrayList<>();
                if (discovered.containsKey(searched.getObjectName())) {
                    products = discovered.get(searched.getObjectName());
                }
                products.add(searched);
                discovered.put(searched.getObjectName(), products);
            }
        }
        return discovered;
    }

    public static void add(Searchable object) {
        objectsMap.add(object);
    }

    public static Searchable findBestResult(String search)
    throws BestResultNotFound {
        Searchable object = null;
        int objectValue = 0;
        for (Searchable searchable : objectsMap) {
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
