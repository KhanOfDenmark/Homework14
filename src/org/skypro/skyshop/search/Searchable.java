package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getObjectType();
    String getObjectName();
    default void getStringRepresentation() {
        System.out.println(getObjectName() +" - " + getObjectType());
    }
}