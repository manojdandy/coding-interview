package llds.applycoupons2;

public class ApplyDiscountMain {
    public static void main(String[] args) {
        Product product = new Item1("banana",10.0);
        Product diccountedProduct = new FlatDiscount(product,10);
        System.out.println(diccountedProduct.getPrice());
    }

}
