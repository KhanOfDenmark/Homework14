package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int PRICE = 777;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return (getTitle() +": Фиксированная цена " +getPrice());
    }
}
