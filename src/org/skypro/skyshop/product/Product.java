package org.skypro.skyshop.product;

public abstract class Product {
    private String title;

    public Product(String title) {
        this.title = title;
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
