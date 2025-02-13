package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String title, int price) throws IllegalArgumentException {
        super(title);
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException("Невозможная цена!");
        }
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return (getTitle() +": " +getPrice());
    }
}
