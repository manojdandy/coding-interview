package llds.applycoupons2;

public enum CategoryType {
    ELECTRONIC("electornic"),VEGTABLES("vegtables");

    final String name;

    CategoryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
