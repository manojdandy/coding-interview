package llds.applycoupons2;

public class FlatDiscount extends Product {
    Product product;
    int discountPercentage;
    public FlatDiscount(Product product,int discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Double getPrice() {
        return (1-discountPercentage/100.0) * product.getPrice();
    }
}
