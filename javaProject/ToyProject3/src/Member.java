import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Member {
	// 인스턴스 변수 정의
	private String name; // 회원 이름
	private String phoneNumber; // 회원 전화번호
	private String email; // 회원 이메일
	private String address; // 회원 주소
	private String id; // 회원 아이디
	private String password; // 회원 비밀번호
	private String nickName; // 회원 닉네임

	private String noMemberId; // 비회원 아이디
	private String noMemberPassword; // 비회원 비밀번호
	private String noMemberName; // 비회원 이름
	private String noMemberAccount; // 비회원 계좌번호
	private String memberAccount; // 회원 계좌번호
	private String noMemberAddress; // 비회원 주소

	private List<String> inventory;
	private int balance;

	// 생성자 정의
	public Member(String name, String phoneNumber, String email, String address, String id, String password,
			String nickName, String noMemberId, String noMemberPassword, String noMemberName, String noMemberAccount,
			String memberAccount, String noMemberAddress, List<String> inventory, int balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
		this.password = password;
		this.nickName = nickName;
		this.noMemberId = noMemberId;
		this.noMemberPassword = noMemberPassword;
		this.noMemberName = noMemberName;
		this.noMemberAccount = noMemberAccount;
		this.noMemberAddress = noMemberAddress;
		this.inventory = inventory;
		this.balance = balance;
	}

	public Member(String noMemberPassword, String noMemberId, int balance) {
		this.balance = balance;
		this.inventory = new ArrayList<>();
	}

	// Getter Setter
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return nickName;
	}

	public String getNoMemberId() {
		return noMemberId;
	}

	public String getNoMemberPassword() {
		return noMemberPassword;
	}

	public String getNoMemberName() {
		return noMemberName;
	}

	public String getNoMemberAccount() {
		return noMemberAccount;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public String getNoMemberAddress() {
		return noMemberAddress;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public int getBalance() { // added getBalance method
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setNoMemberId(String noMemberId) {
		this.noMemberId = noMemberId;
	}

	public void setNoMemberPassword(String noMemberPassword) {
		this.noMemberPassword = noMemberPassword;
	}

	public void setNoName(String noMemberName) {
		this.noMemberName = noMemberName;
	}

	public void setNoMemberAccount(String noMemberAccount) {
		this.noMemberAccount = noMemberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public void setNoMemberAddress(String noMemberAddress) {
		this.noMemberAddress = noMemberAddress;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

class Product {
	// 인스턴스 변수 정의 상품이 있다고 가정
	private String product1;
	private String product2;
	private String product3;
	private String product4;

	// 생성자 정의
	public Product(String product1, String product2, String product3, String product4) {
		this.product1 = product1;
		this.product2 = product2;
		this.product3 = product3;
		this.product4 = product4;
	}

	// Getter Setter
	public String getProduct1() {
		return product1;
	}

	public String getProduct2() {
		return product2;
	}

	public String getProduct3() {
		return product3;
	}

	public String getProduct4() {
		return product4;
	}

	public void setProduct1(String product1) {
		this.product1 = product1;
	}

	public void setProduct2(String product2) {
		this.product2 = product2;
	}

	public void setProduct3(String product3) {
		this.product3 = product3;
	}

	public void setProduct4(String product4) {
		this.product4 = product4;
	}

}

class Admin {

}

class Payment {

}

class Delivery {

}

class MemberController implements MemberCrud {

	private static MemberController instance;
	private ArrayList<Member> member;

	private MemberController() {
		member = new ArrayList<>();
	}

	public ArrayList<Member> getMembers() {
		return member;
	}

	public static MemberController getInstance() {
		if (instance == null) {
			instance = new MemberController();
		}
		return instance;
	}

	@Override
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 로그인 ====");
		System.out.println("아이디를 입력하세요: ");
		String LoginId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String LoginPassword = scan.nextLine();
		boolean notOk = true;
		for (Member loginMember : member) {
			String loginId = loginMember.getId();
			String loginPassword = loginMember.getPassword();
			boolean isOk = loginId.equals(LoginId) && loginPassword.equals(LoginPassword);
			if (isOk) {
				System.out.println("로그인이 완료되었습니다.: ");
				notOk = false;
				break;
			}
		}
		if (notOk) {
			System.out.println("잘못된 입력입니다 관리자에게 문의하세요. ");
		}
	}

	@Override
	public void logout() {
		System.out.println("==== 로그아웃 ====");
		System.out.println("See you again ^.^");
	}

	@Override
	public void createMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 가입 ===");
		System.out.println("이름을 입력하세요: ");
		String name = scan.nextLine();
		System.out.println("전화번호를 입력하세요: ");
		String phoneNumber = scan.nextLine();
		System.out.println("이메일을 입력하세요: ");
		String email = scan.nextLine();
		System.out.println("주소를 입력하세요: ");
		String address = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String id = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password = scan.nextLine();
		System.out.println("닉네임을 입력하세요: ");
		String nickName = scan.nextLine();
		System.out.println("계좌번호를 입력하세요: ");
		String memberAccount = scan.nextLine();
		System.out.println("보유 상품을 입력하세요: ");
		String inventoryInput = scan.nextLine();
		List<String> inventory = Arrays.asList(inventoryInput.split(",")); // added inventory property
		System.out.println("잔액을 입력하세요: ");
		int balance = scan.nextInt(); // added balance property
		scan.nextLine(); // consume the newline character

		System.out.println("회원 정보가 생성되었습니다.");

		Member newMember = new Member(name, phoneNumber, email, address, id, password, nickName, memberAccount,
				memberAccount, memberAccount, memberAccount, memberAccount, memberAccount, inventory, balance);
		member.add(newMember);
	}

	@Override
	public void deleteMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 삭제 ===");
		System.out.println("아이디를 입력하세요: ");
		String DeleteId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String DeletePassword = scan.nextLine();

		boolean notOk = true;
		for (Member deleteMember : member) {
			String deleteId = deleteMember.getId();
			String deletePassword = deleteMember.getPassword();
			boolean isOk = deleteId.equals(DeleteId) && deletePassword.equals(DeletePassword);
			if (isOk) {
				member.remove(deleteMember);
				System.out.println("회원 정보가 삭제되었습니다.");
				notOk = false;
				break;
			}
		}
		if (notOk) {
			System.out.println("잘못된 입력입니다 관리자에게 문의하세요. ");
		}
	}

	@Override
	public void modifyMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 정보 수정 ===");
		System.out.println("아이디를 입력하세요: ");
		String ModifyId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String ModifyPassword = scan.nextLine();

		boolean notOk = true;
		for (Member modifyMember : member) {
			String modifyId = modifyMember.getId();
			String modifyPassword = modifyMember.getPassword();
			boolean isOk = modifyId.equals(ModifyId) && modifyPassword.equals(ModifyPassword);
			if (isOk) {
				System.out.println("새로운 전화번호를 입력하세요: ");
				String newPhoneNumber = scan.nextLine();
				System.out.println("새로운 이메일을 입력하세요: ");
				String newEmail = scan.nextLine();
				System.out.println("새로운 주소를 입력하세요: ");
				String newAddress = scan.nextLine();
				System.out.println("새로운 비밀번호를 입력하세요: ");
				String newPassword = scan.nextLine();
				System.out.println("새로운 닉네임을 입력하세요: ");
				String newNickName = scan.nextLine();

				modifyMember.setPhoneNumber(newPhoneNumber);
				modifyMember.setEmail(newEmail);
				modifyMember.setAddress(newAddress);
				modifyMember.setPassword(newPassword);
				modifyMember.setNickName(newNickName);

				System.out.println("회원 정보가 수정되었습니다.");
				notOk = false;
				break;
			}
		}
		if (notOk) {
			System.out.println("잘못된 아이디 또는 비밀번호입니다.");
		}
	}

	@Override
	public void showDataMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 정보 출력 ===");
		System.out.println("아이디를 입력하세요: ");
		String ShowId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String ShowPassword = scan.nextLine();

		boolean notOk = true;
		for (Member showMember : member) {
			String showId = showMember.getId();
			String showPassword = showMember.getPassword();
			boolean isOk = showId.equals(ShowId) && showPassword.equals(ShowPassword);
			if (isOk) {
				System.out.println("이름: " + showMember.getName());
				System.out.println("전화번호: " + showMember.getPhoneNumber());
				System.out.println("이메일: " + showMember.getEmail());
				System.out.println("주소: " + showMember.getAddress());
				System.out.println("아이디: " + showMember.getId());
				System.out.println("비밀번호: " + showMember.getPassword());
				System.out.println("닉네임: " + showMember.getNickName());
				System.out.println("회원 정보: 출력되었습니다.");
				notOk = false;
				break;
			}
		}
		if (notOk) {
			System.out.println("잘못된 아이디 또는 비밀번호입니다.");
		}
	}

}

class ProductController {

	private static ProductController instance;
	private ArrayList<Product> product;

	private ProductController() {
		product = new ArrayList<>();
	}

	public ArrayList<Product> getProducts() {
		return product;
	}

	public static ProductController getInstance() {
		if (instance == null) {
			instance = new ProductController();
		}
		return instance;
	}

}

class PaymentController implements PaymentCurd {

	private static PaymentController instance;
	private ArrayList<Payment> payments;
	private MemberController memberController;
	private ProductController productController;

	private PaymentController() {
		payments = new ArrayList<>();
		memberController = MemberController.getInstance();
		productController = ProductController.getInstance();
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public static PaymentController getInstance() {
		if (instance == null) {
			instance = new PaymentController();
		}
		return instance;
	}

	@Override
	public void orderProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 상품 주문 ====");
		System.out.println("아이디를 입력하세요: ");
		String OrderId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String OrderPassword = scan.nextLine();

		boolean notOk = true;
		for (Member orderMember : memberController.getMembers()) {
			String orderId = orderMember.getId();
			String passwordOrder = orderMember.getPassword();
			boolean isOk = orderId.equals(OrderId) && passwordOrder.equals(OrderPassword);
			if (isOk) {
				System.out.println("상품 주문입니다.");
				System.out.println("상품을 선택하세요:");
				System.out.println("1. product1");
				System.out.println("2. product2");
				System.out.println("3. product3");
				System.out.println("4. product4");
				String productChoose = scan.nextLine();
				String productName = "";
				int productPrice = 0;
				switch (productChoose) {
				case "1":
					productName = "product1";
					productPrice = 2000;
					break;
				case "2":
					productName = "product2";
					productPrice = 3000;
					break;
				case "3":
					productName = "product3";
					productPrice = 2000;
					break;
				case "4":
					productName = "product4";
					productPrice = 4000;
					break;
				default:
					break;
				}
				if (productName.isEmpty()) {
					System.out.println("상품 주문 실패: 잘못된 상품 정보입니다.");
				} else {
					if (orderMember.getBalance() >= productPrice) {
						int newBalance = orderMember.getBalance() - productPrice;
						List<String> newInventory = new ArrayList<>(orderMember.getInventory());
						newInventory.add(productName);
						orderMember.setBalance(newBalance);
						orderMember.setInventory(newInventory);
						System.out.println("상품 주문이 완료되었습니다.");
						System.out.println("선택한 상품: " + productName);
						System.out.println("잔액: " + orderMember.getBalance());
						System.out.println("보유 상품: " + orderMember.getInventory());
					} else {
						System.out.println("상품 주문 실패: 잔액이 부족합니다.");
					}
				}
				break;
			}
		}
		if (!notOk) {
			System.out.println("상품 주문 실패: 잘못된 회원 정보입니다.");
		}
	}

	@Override
	public void refundProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 상품 환불 ===");
		System.out.println("아이디를 입력하세요: ");
		String refundId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String refundPassword = scan.nextLine();

		boolean notOk = true;
		for (Member refundMember : memberController.getMembers()) {
			String idRefund = refundMember.getId();
			String passwordRefund = refundMember.getPassword();
			if (idRefund.equals(refundId) && passwordRefund.equals(refundPassword)) {
				notOk = false;

				System.out.println("환불할 상품을 선택하세요:");
				List<String> inventory = refundMember.getInventory();
				for (int i = 0; i < inventory.size(); i++) {
					System.out.println((i + 1) + ". " + inventory.get(i));
				}
				int productChoice = scan.nextInt();
				scan.nextLine(); // consume the newline character

				String productName = inventory.get(productChoice - 1);
				int productPrice = getProductPrice(productName); // helper method to get the price of the product
				List<String> newInventory = new ArrayList<>(refundMember.getInventory());
				newInventory.remove(productName);
				int newBalance = refundMember.getBalance() + productPrice;
				refundMember.setInventory(newInventory);
				refundMember.setBalance(newBalance);
				System.out.println("상품 환불이 완료되었습니다.");
				System.out.println("환불한 상품: " + productName);
				System.out.println("잔액: " + refundMember.getBalance());
				System.out.println("보유 상품: " + refundMember.getInventory());

				break;
			}
			break;
		}
		if (notOk) {
			System.out.println("상품 환불 실패: 잘못된 회원 정보입니다.");
		}
	}

	private int getProductPrice(String productName) {
		switch (productName) {
		case "product1":
			return 2000;
		case "product2":
			return 3000;
		case "product3":
			return 2000;
		case "product4":
			return 4000;
		default:
			return 0;
		}
	}

	@Override
	public void changeProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 상품 교환 ===");
		System.out.println("아이디를 입력하세요: ");
		String changeId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String changePassword = scan.nextLine();

		boolean notOk = false;
		for (Member changeMember : memberController.getMembers()) {
			String memberId = changeMember.getId();
			String memberPassword = changeMember.getPassword();
			if (memberId.equals(changeId) && memberPassword.equals(changePassword)) {
				notOk = true;

				System.out.println("교환할 상품을 선택하세요:");
				List<String> inventory = changeMember.getInventory();
				for (int i = 0; i < inventory.size(); i++) {
					System.out.println((i + 1) + ". " + inventory.get(i));
				}
				int oldProductChoice = scan.nextInt();
				scan.nextLine(); // consume the newline character
				if (oldProductChoice < 1 || oldProductChoice > inventory.size()) {
					System.out.println("상품 교환 실패: 잘못된 상품 선택입니다.");
				} else {
					String oldProductName = inventory.get(oldProductChoice - 1);

					System.out.println("새로운 상품을 선택하세요:");
					System.out.println("1. product1");
					System.out.println("2. product2");
					System.out.println("3. product3");
					System.out.println("4. product4");
					int newProductChoice = scan.nextInt();
					scan.nextLine(); // consume the newline character
					String newProductName = "";
					switch (newProductChoice) {
					case 1:
						newProductName = "product1";
						break;
					case 2:
						newProductName = "product2";
						break;
					case 3:
						newProductName = "product3";
						break;
					case 4:
						newProductName = "product4";
						break;
					default:
						break;
					}
					if (newProductName.isEmpty()) {
						System.out.println("상품 교환 : 잘못된 상품 선택입니다.");
					} else {
						int oldProductPrice = getProductPrice(oldProductName);
						int newProductPrice = getProductPrice(newProductName);
						int balanceDiff = newProductPrice - oldProductPrice;
						if (changeMember.getBalance() >= balanceDiff) {
							List<String> newInventory = new ArrayList<>(changeMember.getInventory());
							newInventory.set(oldProductChoice - 1, newProductName);
							int newBalance = changeMember.getBalance() - balanceDiff;
							changeMember.setInventory(newInventory);
							changeMember.setBalance(newBalance);
							System.out.println("상품 교환이 완료되었습니다.");
							System.out.println("이전 상품: " + oldProductName);
							System.out.println("새로운 상품: " + newProductName);
							System.out.println("잔액: " + changeMember.getBalance());
							System.out.println("보유 상품: " + changeMember.getInventory());
						} else {
							System.out.println("상품 교환 실패: 잔액이 부족합니다.");
						}
					}
				}
				break;
			}
		}
		if (!notOk) {
			System.out.println("상품 환불 실패: 잘못된 회원 정보입니다.");
		}
	}

	@Override
	public void orderProductNoMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 상품 주문 ====");
		System.out.println("아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();
		System.out.println("계좌 잔액을 입력하세요: ");
		int noMemberBalance = scan.nextInt();
		scan.nextLine(); // consume the newline character

		Member noMember = new Member(noMemberId, noMemberPassword, noMemberBalance);
		
		System.out.println("상품을 선택하세요:");
		System.out.println("1. product1");
		System.out.println("2. product2");
		System.out.println("3. product3");
		System.out.println("4. product4");
		String productChoose = scan.nextLine();
		String productName = "";
		int productPrice = 0;
		switch (productChoose) {
		case "1":
			productName = "product1";
			productPrice = 2000;
			break;
		case "2":
			productName = "product2";
			productPrice = 3000;
			break;
		case "3":
			productName = "product3";
			productPrice = 2000;
			break;
		case "4":
			productName = "product4";
			productPrice = 4000;
			break;
		default:
			break;
		}
		if (productName.isEmpty()) {
			System.out.println("상품 주문 실패: 잘못된 상품 정보입니다.");
		} else {
			if (noMember.getBalance() >= productPrice) {
				int newBalance = noMember.getBalance() - productPrice;
				List<String> newInventory = new ArrayList<>(noMember.getInventory());
				newInventory.add(productName);
				noMember.setBalance(newBalance);
				noMember.setInventory(newInventory);
				System.out.println("상품 주문이 완료되었습니다.");
				System.out.println("선택한 상품: " + productName);
				System.out.println("잔액: " + noMember.getBalance());
				System.out.println("보유 상품: " + noMember.getInventory());
			} else {
				System.out.println("상품 주문 실패: 잔액이 부족합니다.");
			}
		}
	}

	@Override
	public void refundProductNoMember() {
	}

	@Override
	public void changeProductNoMember() {
	}

}

class AdminController implements AdminManager {

	private static AdminController instance;
	private ArrayList<Admin> admins;
	private MemberController memberController;
	private DeliveryController deliveryController;
	private PaymentController paymentController;

	private AdminController() {
		admins = new ArrayList<>();
		memberController = MemberController.getInstance();
		deliveryController = DeliveryController.getInstance();
		paymentController = PaymentController.getInstance();
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

	@Override
	public void adminLogin() {
	}

	@Override
	public void adminLogout() {
	}

	@Override
	public void memberShowData() {
	}

	@Override
	public void memberModify() {
	}

	@Override
	public void memberDelete() {
	}
}

class DeliveryController implements DeliveryFast {

	private static DeliveryController instance;
	private ArrayList<Delivery> deliveries;
	private MemberController memberController;
	private ProductController productController;
	private PaymentController paymentController;

	private DeliveryController() {
		deliveries = new ArrayList<>();
		memberController = MemberController.getInstance();
		productController = ProductController.getInstance();
		paymentController = PaymentController.getInstance();
	}

	public ArrayList<Delivery> getDeliverys() {
		return deliveries;
	}

	public static DeliveryController getInstance() {
		if (instance == null) {
			instance = new DeliveryController();
		}
		return instance;
	}

	@Override
	public void deliveryStatus() {
	}

	@Override
	public void deliveryDate() {
	}

	@Override
	public void deliveryTracking() {
	}

	@Override
	public void deliveryStatusNoMember() {
	}

	@Override
	public void deliveryDateNoMember() {
	}

	@Override
	public void deliveryTrackingNoMember() {
	}

}

interface MemberCrud {

	// 로그인
	public void login();

	// 로그아웃
	public void logout();

	// 회원 정보 생성
	public void createMember();

	// 회원 정보 삭제
	public void deleteMember();

	// 회원 정보 수정
	public void modifyMember();

	// 회원 정보 출력
	public void showDataMember();
}

interface PaymentCurd {

	// 회원 상품 주문
	public void orderProduct();

	// 회원 상품 환불
	public void refundProduct();

	// 회원 상품 교환
	public void changeProduct();

	// 비회원 상품 주문
	public void orderProductNoMember();

	// 비회원 상품 환불
	public void refundProductNoMember();

	// 비회원 상품 교환
	public void changeProductNoMember();

}

interface DeliveryFast {

	// 회원 배송 상태 조회
	public void deliveryStatus();

	// 회원 배송 날짜 조회
	public void deliveryDate();

	// 회원 운송장 번호 조회
	public void deliveryTracking();

	// 비회원 배송 상태 조회
	public void deliveryStatusNoMember();

	// 비회원 배송 날짜 조회
	public void deliveryDateNoMember();

	// 비회원 운송장 번호 조회
	public void deliveryTrackingNoMember();

}

interface AdminManager {
	// 관리자 로그인
	public void adminLogin();

	// 관리자 로그아웃
	public void adminLogout();

	// 관리자 회원 목록 조회
	public void memberShowData();

	// 관리자 회원 정보 수정
	public void memberModify();

	// 관리자 회원 삭제
	public void memberDelete();
}

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = MemberController.getInstance();
		PaymentController paymentController = PaymentController.getInstance();
		DeliveryController deliveryController = DeliveryController.getInstance();
		AdminController adminCountroller = AdminController.getInstance();

		while (true) {
			System.out.println("======= 메뉴 선택 =======");
			System.out.println("1.  로그인");
			System.out.println("2.  로그아웃");
			System.out.println("3.  회원가입");
			System.out.println("4.  회원정보 출력");
			System.out.println("5.  회원정보 수정");
			System.out.println("6.  회원 삭제");
			System.out.println("7.  회원 상품 주문");
			System.out.println("8.  회원 상품 환불");
			System.out.println("9.  비회원 상품 주문");

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
				paymentController.orderProductNoMember();
				break;
			default:
				System.out.println("잘못된 선택입니다 다시 선택해주세요.");
				break;
			}
		}
	}
}