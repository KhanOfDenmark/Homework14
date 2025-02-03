package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.TreeMap;

public class SearchEngine {
    static TreeMap<String, ArrayList<Searchable>> objectsMap = new TreeMap<>();

    public static TreeMap<String, ArrayList<Searchable>> search(String term) {
        TreeMap<String, ArrayList<Searchable>> discovered = new TreeMap<>();

        for (ArrayList<Searchable> searchedList : objectsMap.values()) {
            for (Searchable searched : searchedList) {
                if (searched.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                    ArrayList<Searchable> products = new ArrayList<>();
                    if (discovered.containsKey(searched.getObjectName())) {
                        products = discovered.get(searched.getObjectName());
                    }
                    products.add(searched);
                    discovered.put(searched.getObjectName(), products);
                }
            }
        }
        return discovered;
    }

    public static void add(Searchable object) {
        ArrayList<Searchable> products = new ArrayList<>();
        if (objectsMap.containsKey(object.getObjectName())) {
            products = objectsMap.get(object.getObjectName());
        }
        products.add(object);
        objectsMap.put(object.getObjectName(), products);
    }

    public static Searchable findBestResult(String search)
    throws BestResultNotFound {
        Searchable object = null;
        int objectValue = 0;
        for (ArrayList<Searchable> objects : objectsMap.values()) {
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
        }
        return object;
    }
}
