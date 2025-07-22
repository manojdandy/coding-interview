package llds.applycoupons2;

public abstract class Product {
    String name;
    Double price;
    CategoryType categoryType;

    public Product() {
    }

    public Product(String name, Double price, CategoryType categoryType) {
        this.name = name;
        this.price = price;
        this.categoryType = categoryType;
    }

    public abstract Double getPrice();

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
