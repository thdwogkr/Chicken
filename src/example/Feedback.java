package example;

public class Feedback {
    private String customerName;
    private String shopName;
    private int grade;
    private String foodName;

    Feedback(String customerName, String shopName, int grade, String foodName) {
        this.customerName = customerName;
        this.shopName = shopName;
        this.grade = grade;
        this.foodName = foodName;
    }

    public String getStarts() {
        return "★".repeat(this.grade);
    }

    public void printInfo() {
        System.out.println(this.customerName + " [고객님]");
        System.out.println("-------------------------");
        System.out.println("주문 매장 : " + this.shopName);
        System.out.println("주문 메뉴 : " + this.foodName);
        System.out.println("별점 : " + this.getStarts());
        System.out.println("");
    }
}
