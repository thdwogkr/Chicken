package example;

import java.util.Scanner;

public class KDeliveryMainV1 {

    private Feedback[] feedbacks;
    private int feedbackIdx = 0;
    private static int SHOP_MAX = 5;
    private Shop[] shops;
    private static int ORDER_MAX = 5;
    private Order[] orders;
    private int orderIdx = 0;
    private static int FEEDBACK_MAX = ORDER_MAX;
    private int shopIdx = 0;
    private static Scanner sc;

    private void initValues() {
        feedbacks = new Feedback[FEEDBACK_MAX];
        shops = new Shop[SHOP_MAX];
        orders = new Order[ORDER_MAX];
    }

    public void selectOrderMenu() {
        System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!\n" +
                "[안내] 주문자 이름을 알려주세요!");
        System.out.print(">>> ");
        String customerName = sc.next();
        System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String shopName = sc.next();
        System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
        System.out.print(">>> ");
        String menuName = sc.next();

        Order order = new Order(shopName, customerName, menuName);
        orders[orderIdx++] = order;

        System.out.printf("[안내] %s님!\n" +
                "[안내] %s매장에 %s주문이 완료되었습니다.", customerName, shopName, menuName);
    }
    public void close() {

    }

    public void selectAddShopMenu() {
        System.out.println("[안내] 반갑습니다. 가맹주님!\n" +
                "[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String shopName = sc.next();
        System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
        System.out.print(">>> ");
        String menuName = sc.next();
        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
        System.out.print(">>> ");
        int price = sc.nextInt();
        Shop shop = new Shop(shopName);
        shop.addFood(0, menuName, price);
        System.out.printf("[안내]노랑 통닭에 음식(%s, %d) 추가되었습니다.\n" +
                "[시스템] 가게 등록이 정상 처리되었습니다.", menuName, price);
        shops[shopIdx++] = shop;
    }
    public int selectMainMenu() {
        System.out.println("-------------------------\n" +
                "1) [사장님용] 음식점 등록하기\n" +
                "2) [고객님과 사장님용] 음식점 별점 조회하기\n" +
                "3) [고객님용] 음식 주문하기\n" +
                "4) [고객님용] 별점 등록하기\n" +
                "5) 프로그램 종료하기\n" +
                "-------------------------");
        System.out.println("[시스템] 무엇을 도와드릴까요? ");
        System.out.print(">>> ");
        return sc.nextInt();
    }
    public void selectFeedbackMenu() {
        System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        System.out.print(">>> ");
        String customerName = sc.next();
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        String shopName = sc.next();
        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
        System.out.print(">>> ");
        String menuName = sc.next();
        System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
        System.out.print(">>> ");
        int grade = sc.nextInt();
        System.out.println("[안내] 리뷰 등록이 완료되었습니다.");

        Feedback feedback = new Feedback(customerName, shopName, grade, menuName);
        feedbacks[feedbackIdx++] = feedback;
    }
    public void selectDashboardMenu() {
        for(int i=0; i<feedbackIdx; i++) {
            feedbacks[i].printInfo();
        }
    }

    public static void main(String[] args) {
        System.out.println("[치킨의 민족 프로그램 V1] ");
        int select = 0;
        sc = new Scanner(System.in);
        KDeliveryMainV1 kdm = new KDeliveryMainV1();
        kdm.initValues();

        while (select != 5) {
            select = kdm.selectMainMenu();

            switch (select) {
                case 1:
                    kdm.selectAddShopMenu();
                    break;
                case 2:
                    kdm.selectDashboardMenu();
                    System.out.println("음식점 별점 조회");
                    break;
                case 3:
                    kdm.selectOrderMenu();
                    break;
                case 4:
                    kdm.selectFeedbackMenu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    break;
            }
        }
        System.out.println("[안내] 이용해주셔서 감사합니다.");
    }

}
