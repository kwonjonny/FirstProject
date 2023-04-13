import java.util.ArrayList;
import java.util.Scanner;

// 주문 Controller  
public class OrderController implements OrderShowData {

	private static OrderController instance;
	private ArrayList<Order> orders;
	private MemberController memberController;
	private NoMemberController noMemberController;
	private ProductController productController;

	private OrderController() {
		orders = new ArrayList<>();
		memberController = MemberController.getInstance();
		noMemberController = NoMemberController.getInstance();
		productController = ProductController.getInstance();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public static OrderController getInstance() {
		if (instance == null) {
			instance = new OrderController();
		}
		return instance;
	}

	// 회원 주문 상태 조회 로직
	@Override
	public void memberOrderShowData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 주문 상태 조회 ===");
		System.out.println("아이디 입력: ");
		String id = scan.nextLine();
		System.out.println("비밀번호 입력: ");
		String password = scan.nextLine();

		boolean notOk = true;
		for (Member order : memberController.getMembers()) {
			String showDataId = order.getId();
			String showDataPassword = order.getPassword();
			boolean isOk = showDataId.equals(id) && showDataPassword.equals(password);
			if (isOk) {
				System.out.println("보유 상품: " + order.getInventory());
				notOk = false;
				break;
			}
			if (notOk) {
				System.out.println("회원 상품 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 정보 출력 로직
	@Override
	public void noMemberOrderShowData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 비회원 주문 상태 조회 ===");
		System.out.println("아이디 입력: ");
		String NoMemberId = scan.nextLine();
		System.out.println("비밀번호 입력: ");
		String NoMemberPassword = scan.nextLine();

		boolean notOk = true;
		for (NoMember noOrder : noMemberController.getNoMembers()) {
			String showDataNoId = noOrder.getNoMemberId();
			String showDataNoPassword = noOrder.getNoMemberPassword();
			boolean isOk = showDataNoId.equals(NoMemberId) && showDataNoPassword.equals(NoMemberPassword);
			if (isOk) {
				System.out.println("보유 상품:" + noOrder.getNoMemberInventory());
				notOk = false;
				break;
			}
			if (notOk) {
				System.out.println("회원 상품 조회 실패: 잘못된 입력입니다.");
			}
		}
	}
}
