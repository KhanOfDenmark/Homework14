package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    static void println(Object text) {
        System.out.println(text);
    }

    static void putASeparator() {
        println("***");
    }

    public static void main(String[] args) {
        /*Добавление продукта в корзину.
Добавление продукта в заполненную корзину, в которой нет свободного места.
Печать содержимого корзины с несколькими товарами.
Получение стоимости корзины с несколькими товарами.
Поиск товара, который есть в корзине.
Поиск товара, которого нет в корзине.
Очистка корзины.
Печать содержимого пустой корзины.
Получение стоимости пустой корзины.
Поиск товара по имени в пустой корзине.*/
        putASeparator();
        ProductBasket.addAProductToBasket("Карандаш", 25);
        ProductBasket.addAProductToBasket("Степлер");
        ProductBasket.addAProductToBasket("Крышка", 20, 30);
        ProductBasket.addAProductToBasket("Карандаш", 25);
        ProductBasket.addAProductToBasket("Ручка", 105, 10);
        ProductBasket.addAProductToBasket("Карандаш", 25);

        putASeparator();
        ProductBasket.printTheContentsOfTheBasket();

        putASeparator();
        println(ProductBasket.getTheTotalCostValue());

        putASeparator();
        println(ProductBasket.checkTheProductAvailabilityInTheBasket("крышка"));

        putASeparator();
        println(ProductBasket.checkTheProductAvailabilityInTheBasket("Ластик"));

        putASeparator();
        ProductBasket.emptyTheBasket();

        ProductBasket.printTheContentsOfTheBasket();

        putASeparator();
        println(ProductBasket.getTheTotalCostValue());

        putASeparator();
        println(ProductBasket.checkTheProductAvailabilityInTheBasket("крышка"));
    }
}