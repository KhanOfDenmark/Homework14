package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String title;

    public Product(String title) throws IllegalArgumentException {
        this.title = title;
        if (title.isBlank()) {
            throw new IllegalArgumentException("Неправильное название продукта!");
        }
    }

    @Override
    public String getSearchTerm() {
        return this.title;
    }

    @Override
    public String getObjectType() {
        return "PRODUCT";
    }

    @Override
    public String getObjectName() {
        return this.title;
    }

    public abstract boolean isSpecial();

    public String getTitle() {
        return title;
    }
    public abstract int getPrice();

    public void setTitle(String title) {
        this.title = title;
    }
}
