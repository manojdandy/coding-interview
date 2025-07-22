package llds.applycoupons2;

public class Item1 extends Product {

    public Item1(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return this.price;
    }
}
