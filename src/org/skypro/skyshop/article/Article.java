package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name +"\n" +text;
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getObjectType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
