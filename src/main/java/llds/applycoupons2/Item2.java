package llds.applycoupons2;

public class Item2 extends Product {

    public Item2(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return 0.0;
    }
}
