package org.skypro.skyshop.search;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class SearchEngine {
    static HashSet<Searchable> objectsSet = new HashSet<>();

    public static TreeSet<Searchable> search(String term) {
        TreeSet<Searchable> discovered = new TreeSet<>(new SearchableComparator());

        for (Searchable searched : objectsSet) {
            if (searched.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                discovered.add(searched);
            }
        }
        return discovered;
    }

    public static void add(Searchable object) {
        objectsSet.add(object);
    }

    public static Searchable findBestResult(String search)
    throws BestResultNotFound {
        Searchable object = null;
        int objectValue = 0;
        for (Searchable searchable : objectsSet) {
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

    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s1.getObjectName().length() == s2.getObjectName().length()) {
                return s1.getObjectName().compareTo(s2.getObjectName());
            }
            return Integer.compare(s1.getObjectName().length(), s2.getObjectName().length());
        }
    }
}

