package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private static LinkedList<Product> basket = new LinkedList<>();

    public static void addAProductToBasket(String title, int price) {
        basket.add(new SimpleProduct(title, price));
        System.out.println("Товар [" +title +"] добавлен.");
    }

    public static void addAProductToBasket(String title, int price, int percent) {
        basket.add(new DiscountedProduct(title, price, percent));
        System.out.println("Товар [" +title +"] добавлен.");
    }

    public static void addAProductToBasket(String title) {
        basket.add(new FixPriceProduct(title));
        System.out.println("Товар [" +title +"] добавлен.");
    }

    public static int getTheTotalCostValue() {
        int totalCost = 0;
        for (Product product:basket) if (product != null) totalCost += product.getPrice();
        return totalCost;
    }

    public static void printTheContentsOfTheBasket() {
        int numberOfSpecialProduct = 0;
        for (Product product:basket) {
            if (product.getClass() == FixPriceProduct.class
                    || product.getClass() == DiscountedProduct.class) {
                numberOfSpecialProduct++;
            }
        }
        System.out.println(basket);
        System.out.println("---");
        if (getTheTotalCostValue() != 0) {
            System.out.println("Итого: " +getTheTotalCostValue());
            System.out.println("Специальных товаров: " +numberOfSpecialProduct);
        }
        else System.out.println("В корзине пусто.");
    }

    public static boolean checkTheProductAvailabilityInTheBasket(String title) {
        for (Product product:basket) if (product != null && product.getTitle().equalsIgnoreCase(title)) return true;
        return false;
    }

    public static void emptyTheBasket() {
        basket.clear();
    }

    public static LinkedList<Product> removeProductsFromTheBasket(String title) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getTitle().equalsIgnoreCase(title)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
