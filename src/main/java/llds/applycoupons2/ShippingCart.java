package llds.applycoupons2;

import java.util.List;

public class ShippingCart {
    List<Product> productList;

    public void addToCart(Product product) {
        productList.add(product);
    }

    public Double getTotalPrice() {

        return 0.0;
    }

}
