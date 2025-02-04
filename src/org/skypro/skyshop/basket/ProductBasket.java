package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {
    private static HashMap<String, LinkedList<Product>> basket = new HashMap<>();

    public static void addProduct(String title, int price) {
        LinkedList<Product> products = new LinkedList<>();
        if (basket.containsKey(title)) {
            products = basket.get(title);
        }
        products.add(new SimpleProduct(title, price));
        basket.put(title, products);
        System.out.println("Товар [" + title + "] добавлен.");
    }

    public static void addProduct(String title, int price, int percent) {
        LinkedList<Product> products = new LinkedList<>();
        if (basket.containsKey(title)) {
            products = basket.get(title);
        }
        products.add(new DiscountedProduct(title, price, percent));
        basket.put(title, products);
        System.out.println("Товар [" + title + "] добавлен.");
    }

    public static void addProduct(String title) {
        LinkedList<Product> products = new LinkedList<>();
        if (basket.containsKey(title)) {
            products = basket.get(title);
        }
        products.add(new FixPriceProduct(title));
        basket.put(title, products);
        System.out.println("Товар [" + title + "] добавлен.");
    }

    public static void addProduct(Product product) {
        LinkedList<Product> products = new LinkedList<>();
        if (basket.containsKey(product.getObjectName())) {
            products = basket.get(product.getObjectName());
        }
        products.add(product);
        basket.put(product.getObjectName(), products);
        System.out.println("Товар [" + product.getObjectName() + "] добавлен.");
    }

    public static int getTheTotalCostValue() {
        int totalCost = 0;
        for (LinkedList<Product> products : basket.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public static void printTheContentsOfTheBasket() {
        int numberOfSpecialProduct = 0;
        for (LinkedList<Product> products : basket.values()) {
            for (Product product : products) {
                if (product.getClass() == FixPriceProduct.class
                        || product.getClass() == DiscountedProduct.class) {
                    numberOfSpecialProduct++;
                }
            }
        }
        System.out.println(basket);
        System.out.println("---");
        if (getTheTotalCostValue() != 0) {
            System.out.println("Итого: " + getTheTotalCostValue());
            System.out.println("Специальных товаров: " + numberOfSpecialProduct);
        } else System.out.println("В корзине пусто.");
    }

    public static boolean checkTheProductAvailabilityInTheBasket(String title) {
        for (LinkedList<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null && product.getTitle().equalsIgnoreCase(title)) return true;
            }
        }
        return false;
    }

    public static void emptyTheBasket() {
        basket.clear();
    }

    public static LinkedList<Product> removeProductsFromTheBasket(String title) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        for (LinkedList<Product> products : basket.values()) {
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getTitle().equalsIgnoreCase(title)) {
                    removedProducts.add(product);
                    iterator.remove();
                }
            }
        }
        return removedProducts;
    }
}