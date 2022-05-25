package example;

public class Order {
    public String getShopName() {
        return shopName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getFoodName() {
        return foodName;
    }

    private String shopName;
    private String customerName;
    private String foodName;

    Order(String shopName, String customerName, String foodName) {
        this.shopName = shopName;
        this.customerName = customerName;
        this.foodName = foodName;
    }
}
