package example;

public class Shop {
//    public void setShopName(String shopName) {
//        this.shopName = shopName;
//    }
    private static final int FOOD_MAX = 5;
    public String shopName;
    private String[] foodNames = new String[FOOD_MAX];
    private int[] prices = new int[FOOD_MAX];


    private static final String EMPTY_FOOD = "음식이름";
    private static final int EMPTY_PRICE = 0;
    private int foodIdx = 0;



    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public void addFood(String name, int price) {
        if (foodIdx <5 ) {
            prices[foodIdx] = price;
            foodNames[foodIdx++] = name;
            System.out.printf("[안내]%s에 음식(%s, %d) 추가되었습니다.\n" +
                    "[시스템] 가게 등록이 정상 처리되었습니다.", shopName, name, price);
        } else System.out.printf("%s 가게에 등록할 수 있는 메뉴의 개수를 초과했습니다. (최대 5개)",shopName);
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
