package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    private int basePrice;
    private int discountInWholePercentages;

    public DiscountedProduct(String title, int basePrice, int discountInWholePercentages)
            throws IllegalArgumentException {
        super(title);
        this.basePrice = basePrice;
        this.discountInWholePercentages = discountInWholePercentages;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Невозможная цена!");
        }
        if (discountInWholePercentages > 100 || discountInWholePercentages < 0) {
            throw new IllegalArgumentException("Невозможная скидка!");
        }
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        if (this.discountInWholePercentages<=100 && this.discountInWholePercentages>=0) {
            return basePrice - (basePrice/100*discountInWholePercentages);
        } else {
            return basePrice;
        }
    }
    public int getDiscountInWholePercentages() {
        if (this.discountInWholePercentages<=100 && this.discountInWholePercentages>=0) {
            return discountInWholePercentages;
        } else {
            return 0;
        }
    }

    public void setPrice(int price) {
        basePrice = price;
    }

    public void setDiscountInWholePercentages(int discountInWholePercentages) {
        this.discountInWholePercentages = discountInWholePercentages;
    }

    @Override
    public String toString() {
        return (getTitle() +": " +getPrice() +" (" +getDiscountInWholePercentages() +"% скидка)");
    }
}
