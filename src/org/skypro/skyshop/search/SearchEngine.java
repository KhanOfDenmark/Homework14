package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    Searchable[] objects;

    public SearchEngine(int value) {
        this.objects = new Searchable[value];
    }

    public Searchable[] search(String term) {
        Searchable[] discovered = new Searchable[5];
        for (Searchable object:objects) {
            if (object.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                for (int i = 0; i < discovered.length; i++) {
                    if (discovered[i] == null) {
                        discovered[i] = object;
                        break;
                    }
                }
            }
        }
        return discovered;
    }

    public void add(Searchable object) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = object;
                break;
            }
        }
    }

    public Searchable findBestResult(String search)
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
