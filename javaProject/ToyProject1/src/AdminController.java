import java.util.ArrayList;
import java.util.Scanner;

// 관리자 Controller 
public class AdminController implements AdminManager {

	private static AdminController instance;
	private ArrayList<Admin> admins;
	private MemberController memberController;
	private NoMemberController noMemberController;
	private PaymentController paymentController;
	private OrderController orderController;
	private DeliveryController deliveryController;

	private AdminController() {
		admins = new ArrayList<>();
		memberController = MemberController.getInstance();
		noMemberController = NoMemberController.getInstance();
		deliveryController = DeliveryController.getInstance();
		paymentController = PaymentController.getInstance();
		orderController = OrderController.getInstance();
	}

	public ArrayList<Admin> getAdmins() {
		return admins;
	}

	public static AdminController getInstance() {
		if (instance == null) {
			instance = new AdminController();
		}
		return instance;
	}

	// 값 임의 지정
	private String adminId;
	private String adminPassword;

	@Override
	public void adminLogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("관리자 아이디를 입력하세요: ");
		String adminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String adminPassword = scan.nextLine();

		if (adminId.equals("admin") && adminPassword.equals("admin")) {
			System.out.println("로그인 완료");
			System.out.println("회원 이름을 입력하세요: ");
			String name = scan.nextLine();
			for (Member member : memberController.getMembers()) {
				if (member.getName().equals(name)) {
					System.out.println("회원 아이디: " + member.getId());
					System.out.println("회원 이름: " + member.getName());
					System.out.println("회원 전화번호: " + member.getPhoneNumber());
					System.out.println("회원 배송지 주소: " + member.getAddress());
					System.out.println("회원 장바구니: " + member.getInventory());
					System.out.println("==============");
					return;
				}
			}
			System.out.println("해당 이름의 회원을 찾을 수 없습니다.");
		} else {
			System.out.println("관리자 로그인 실패: 잘못된 입력입니다.");
		}
	}

	// 관리자 로그아웃 로직
	@Override
	public void adminLogout() {
		System.out.println("See you again ^^");
	}

	// 관리자 -> 회원 정보 출력 로직
	@Override
	public void memberShowData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 관리자 회원 정보 출력 ===");
		System.out.println("관리자 아이디를 입력하세요: ");
		String adminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String adminPassword = scan.nextLine();

		if (adminId.equals("admin") && adminPassword.equals("admin")) {
			System.out.println("로그인 완료");
			System.out.println("회원 이름을 입력하세요: ");
			String name = scan.nextLine();
			for (Member member : memberController.getMembers()) {
				if (member.getName().equals(name)) {
					System.out.println("회원 아이디: " + member.getId());
					System.out.println("회원 이름: " + member.getName());
					System.out.println("회원 전화번호: " + member.getPhoneNumber());
					System.out.println("회원 배송지 주소: " + member.getAddress());
					System.out.println("회원 장바구니: " + member.getInventory());
					System.out.println("==============");
					return;
				}
			}
			System.out.println("존재하지 않는 회원 이름입니다.");
		} else {
			System.out.println("관리자 로그인 실패: 잘못된 입력입니다.");
		}
	}

	// 관리자 -> 회원 정보 수정 로직
	@Override
	public void memberModify() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 관리자 회원 정보 수정 ===");
		System.out.println("관리자 아이디를 입력하세요: ");
		String adminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String adminPassword = scan.nextLine();

		if (adminId.equals("admin") && adminPassword.equals("admin")) {
			System.out.println("로그인 완료");
			System.out.println("회원 이름을 입력하세요: ");
			String name = scan.nextLine();
			for (Member member : memberController.getMembers()) {
				if (member.getName().equals(name)) {
					System.out.println("새로운 이름 입력: ");
					String newName = scan.nextLine();
					member.setName(newName);
					System.out.println("새로운 전화번호를 입력하세요: ");
					String newPhoneNumber = scan.nextLine();
					member.setPhoneNumber(newPhoneNumber);
					System.out.println("새로운 이메일을 입력하세요: ");
					String newEmail = scan.nextLine();
					member.setEmail(newEmail);
					System.out.println("새로운 주소를 입력하세요: ");
					String newAddress = scan.nextLine();
					member.setAddress(newAddress);
					System.out.println("새로운 아이디를 입력하세요: ");
					String newId = scan.nextLine();
					member.setId(newId);
					System.out.println("새로운 비밀번호를 입력하세요: ");
					String newPassword = scan.nextLine();
					member.setPassword(newPassword);
					System.out.println("새로운 닉네임을 입력하세요: ");
					String newNickName = scan.nextLine();
					member.setNickName(newNickName);
					System.out.println("새로운 계좌번호를 입력하세요: ");
					String newAccount = scan.nextLine();
					member.setMemberAccount(newAccount);
					System.out.println("회원 수정이 완료되었습니다.");
					break;
				}
			}
		}
	}

	// 관리자 -> 회원 정보 삭제 로직
	@Override
	public void memberDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 관리자 회원 정보 삭제 ===");
		System.out.println("관리자 아이디를 입력하세요: ");
		String adminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String adminPassword = scan.nextLine();

		if (adminId.equals("admin") && adminPassword.equals("admin")) {
			System.out.println("로그인 완료");
			System.out.println("회원 이름을 입력하세요: ");
			String name = scan.nextLine();
			for (Member member : memberController.getMembers()) {
				if (member.getName().equals(name)) {
					memberController.getMembers().remove(member);
					System.out.println("회원이 삭제되었습니다.");
				}
			}

		}
	}
}
