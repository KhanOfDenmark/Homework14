package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private static Product[] basket = new Product[5];

    public static void addAProductToBasket(String title, int price) {
        boolean isAdded = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = new Product(title, price);
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
        for (Product product:basket) {
            if (product != null) System.out.println(product.getTitle() +": " +product.getPrice());
        }
        if (getTheTotalCostValue() != 0) System.out.println("Итого: " +getTheTotalCostValue());
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
