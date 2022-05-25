package example;

import java.util.Scanner;

public class KDeliveryMainV1 {
    private static int SHOP_MAX = 5;
    private static int ORDER_MAX = 5;
    private static int FEEDBACK_MAX = ORDER_MAX;

    private static Shop[] shops = new Shop[SHOP_MAX];
    private static Order[] orders = new Order[ORDER_MAX];
    private static Feedback[] feedbacks = new Feedback[FEEDBACK_MAX];

    private static int shopIdx = 0;
    private static int orderIdx = 0;
    private static int feedbackIdx = 0;

    private static Scanner sc;


    public static void selectOrderMenu() {
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

        // 음식점과 메뉴가 등록되어있는지 입력값과 비교
        boolean isSuccess = false;
        for( int i = 0; i<shopIdx ; i++) {
            if ( shops[i].checkMenu(shopName, menuName)) {

                orders[orderIdx++] = new Order(shopName, customerName, menuName);

                System.out.printf("[안내] %s님!\n" +
                        "[안내] %s매장에 %s주문이 완료되었습니다.", customerName, shopName, menuName);
                isSuccess = true;
                break;
            }
        }

        if( !isSuccess ) System.out.println("매장명 or 메뉴명을 확인해주세요.");



    }
    public static void close() {
        System.out.println("[안내] 이용해주셔서 감사합니다.");
    }

    public static void selectAddShopMenu() {
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

        boolean isExist = false;
        for (int i = 0 ; i < shopIdx ; i ++) {
            if(shops[i].shopName.equals(shopName)) {
                shops[i].addFood(menuName, price);
                isExist = true;
                break;
            }
        }

        if( !isExist ) {
            shops[shopIdx] = new Shop(shopName);
            shops[shopIdx++].addFood(menuName, price);
        }

    }
    public static int selectMainMenu() {
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
    public static void selectFeedbackMenu() {
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


        boolean isExist = false;
        for (int i = 0; i < orderIdx; i++) {
            if(orders[i].getCustomerName().equals(customerName) &&
                orders[i].getShopName().equals(shopName) &&
                    orders[i].getFoodName().equals(menuName)     ) {
                feedbacks[feedbackIdx++] = new Feedback(customerName, shopName, grade, menuName);
                System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
                isExist = true;
                break;
            }
        }

        if ( !isExist ) {
            System.out.println("주문자 이름 or 상호명 or 음식이름을 확인해주세요.");
        }



    }
    public static void selectDashboardMenu() {
        for(int i=0; i<feedbackIdx; i++) {
            feedbacks[i].printInfo();
        }
    }

    public static void main(String[] args) {
        System.out.println("[치킨의 민족 프로그램 V1] ");
        int select = 0;
        sc = new Scanner(System.in);

        while (select != 5) {
            select = selectMainMenu();

            switch (select) {
                case 1:
                    selectAddShopMenu();
                    break;
                case 2:
                    selectDashboardMenu();
                    System.out.println("음식점 별점 조회");
                    break;
                case 3:
                    selectOrderMenu();
                    break;
                case 4:
                    selectFeedbackMenu();
                    break;
                case 5:
                    close();
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    break;
            }
        }

    }

}
