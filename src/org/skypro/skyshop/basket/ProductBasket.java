package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class ProductBasket {
    private static Product[] basket = new Product[5];

    public static void addAProductToBasket(String title, int price) {
        boolean isAdded = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = new SimpleProduct(title, price);
                isAdded = true;
                break;
            }
        }
        if (isAdded == false) System.out.println("Невозможно добавить продукт.");
        else System.out.println("Товар [" +title +"] добавлен.");
    }

    public static void addAProductToBasket(String title, int price, int percent) {
        boolean isAdded = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = new DiscountedProduct(title, price, percent);
                isAdded = true;
                break;
            }
        }
        if (isAdded == false) System.out.println("Невозможно добавить продукт.");
        else System.out.println("Товар [" +title +"] добавлен.");
    }

    public static void addAProductToBasket(String title) {
        boolean isAdded = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = new FixPriceProduct(title);
                isAdded = true;
                break;
            }
        }
        if (isAdded == false) System.out.println("Невозможно добавить продукт.");
        else System.out.println("Товар [" +title +"] добавлен.");
    }

    public static int getTheTotalCostValue() {
        int totalCost = 0;
        for (Product product:basket) if (product != null) totalCost += product.getPrice();
        return totalCost;
    }

    public static void printTheContentsOfTheBasket() {
        int numberOfSpecialProduct = 0;
        for (Product product:basket) {
            if (product != null) {
                if (product.getClass() == FixPriceProduct.class) {
                    numberOfSpecialProduct++;
                    System.out.println(product);
                } else if (product.getClass() == SimpleProduct.class) {
                    System.out.println(product);
                } else if (product.getClass() == DiscountedProduct.class) {
                    numberOfSpecialProduct++;
                    System.out.println(product);
                }
            }
        }
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
        Arrays.fill(basket, null);
    }
}
