package example;

public class Shop {
    private int[] prices;
    private String[] foodNames;
    private static final String EMPTY_FOOD = "음식이름";
    private static final int FOOD_MAX = 5;
    private static final int EMPTY_PRICE = 0;
    private int foodIdx;
    public String shopName;

    public Shop(String shopName) {

        this.shopName = shopName;
        initValues();
    }

    private void initValues() {
        prices = new int[FOOD_MAX];
        foodNames = new String[FOOD_MAX];
        foodIdx = 0;
    }

    public void addFood(String name, int price) {
        if (foodIdx <5 ) {
            prices[foodIdx] = price;
            foodNames[foodIdx++] = name;
        } else System.out.println("등록할 수 있는 메뉴의 개수를 초과했습니다. (최대 5개)");
    }

    public boolean checkMenu(String shopName, String foodName) {
        if (this.shopName.equals(shopName)) {
            for (int i = 0; i < foodIdx; i++) {
                if (this.foodNames[i].equals(foodName)) {
                    return true;
                }
            }
        }
        return false;
    }


}
