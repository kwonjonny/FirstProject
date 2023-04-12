import java.util.Scanner;

// 메인 클래스 
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = MemberController.getInstance();
		NoMemberController noMemberController = NoMemberController.getInstance();
		ProductController productController = ProductController.getInstance();
		PaymentController paymentController = PaymentController.getInstance();
		DeliveryController deliveryController = DeliveryController.getInstance();
		OrderController orderController = OrderController.getInstance();
		AdminController adminController = AdminController.getInstance();

		while (true) {
			System.out.println("===============================================");
			System.out.println("|                 메뉴 선택                    |");
			System.out.println("===============================================");
			System.out.println("1.로그인 					2.로그아웃 				3.회원가입 ");
			System.out.println("4.회원정보 출력 			5.회원정보 수정 			6.회원 삭제");
			System.out.println("7.회원 상품 주문 			8.회원 상품 환불 			9.회원 상품 교환");
			System.out.println("10.비회원 상품 주문 		11.비회원 상품 환불 		12.비회원 상품 교환");
			System.out.println("13.회원 상품 조회 			14.비회원 상품 조회 		15.회원 배송 상태 조회");
			System.out.println("16.회원 배송 날짜 조회 		17.회원 운송장 번호 조회 	18.비회원 배송 상태 조회");
			System.out.println("19.비회원 배송 날짜 조회 	20.비회원 운송장 번호 조회 	21.관리자 로그인");
			System.out.println("22.관리자 로그아웃 			23.관리자 회원 조회		    24.관리자 회원 정보 수정");
			System.out.println("25.관리자 회원 정보 삭제");
			System.out.println("===============================================");

			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				memberController.login();
				break;
			case 2:
				memberController.logout();
				break;
			case 3:
				memberController.createMember();
				break;
			case 4:
				memberController.showDataMember();
				break;
			case 5:
				memberController.modifyMember();
				break;
			case 6:
				memberController.deleteMember();
				break;
			case 7:
				paymentController.orderProduct();
				break;
			case 8:
				paymentController.refundProduct();
				break;
			case 9:
				paymentController.changeProduct();
				break;
			case 10:
				paymentController.orderProductNoMember();
				break;
			case 11:
				paymentController.refundProductNoMember();
				break;
			case 12:
				paymentController.changeProductNoMember();
				break;
			case 13:
				orderController.memberOrderShowData();
				break;
			case 14:
				orderController.noMemberOrderShowData();
				break;
			case 15:
				deliveryController.deliveryStatus();
				break;
			case 16:
				deliveryController.deliveryDate();
				break;
			case 17:
				deliveryController.deliveryTracking();
				break;
			case 18:
				deliveryController.deliveryStatusNoMember();
				break;
			case 19:
				deliveryController.deliveryDateNoMember();
				break;
			case 20:
				deliveryController.deliveryTrackingNoMember();
				break;
			case 21:
				adminController.adminLogin();
				break;
			case 22:
				adminController.adminLogout();
				break;
			case 23:
				adminController.memberShowData();
				break;
			case 24:
				adminController.memberModify();
				break;
			case 25:
				adminController.memberDelete();
			default:
				System.out.println("잘못된 선택입니다 다시 선택해주세요.");
				break;
			}
		}
	}
}