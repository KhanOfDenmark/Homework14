package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static int numberOfSeparator = 1;
    static void println(Object text) {
        System.out.println(text);
    }

    static void putASeparator() {
        println("*** " + numberOfSeparator++ + " ***");
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

        putASeparator();
        SearchEngine search = new SearchEngine(8);
        Article pencilArticle = new Article("Карандаш","Простой карандаш");
        Article penArticle = new Article("Ручка","Пластиковая ручка с синими чернилами");
        Article staplerArticle = new Article("Степлер","Степлер в пластиковом корпусе");
        search.add(new SimpleProduct("Карандаш",25));
        search.add(new FixPriceProduct("Степлер"));
        search.add(new DiscountedProduct("Крышка", 20, 30));
        search.add(new SimpleProduct("Карандаш", 25));
        search.add(new DiscountedProduct("Ручка", 105, 10));
        search.add(pencilArticle);
        search.add(penArticle);
        search.add(staplerArticle);

        for (Searchable searched:search.search("ручка")) {
            if (searched!=null) {
            searched.getStringRepresentation();
            }
        }

        //Домашнее задание #17
        putASeparator();
        ProductBasket.emptyTheBasket();
        try {
            ProductBasket.addAProductToBasket("Карандаш", -56);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        try {
            ProductBasket.addAProductToBasket("   ");
        } catch (IllegalArgumentException e) {
            println(e);
        }
        try {
            ProductBasket.addAProductToBasket("Крышка", 20, 123);
        } catch (IllegalArgumentException e) {
            println(e);
        }

        putASeparator();
        try {
            println(search.findBestResult("кар"));
        } catch (BestResultNotFound e) {
            println(e);
        }

        putASeparator();
        try {
            println(search.findBestResult("тон"));
        } catch (BestResultNotFound e) {
            println(e);
        }

        putASeparator();
    }
}