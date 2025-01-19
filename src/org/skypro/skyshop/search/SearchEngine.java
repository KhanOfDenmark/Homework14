package org.skypro.skyshop.search;

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
}
