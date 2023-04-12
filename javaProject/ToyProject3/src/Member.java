import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 회원 클래스 
public class Member {
	// 인스턴스 변수 정의
	private String name; // 회원 이름
	private String phoneNumber; // 회원 전화번호
	private String email; // 회원 이메일
	private String address; // 회원 주소
	private String id; // 회원 아이디
	private String password; // 회원 비밀번호
	private String nickName; // 회원 닉네임
	private String memberAccount; // 회원 계좌번호
	private List<String> inventory;
	private int balance;

	// 생성자 정의
	public Member(String name, String phoneNumber, String email, String address, String id, String password,
			String nickName, String memberAccount, List<String> inventory, int balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
		this.password = password;
		this.nickName = nickName;
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

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
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

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

// 비회원 클래스 
class NoMember {

	private String noMemberId; // 비회원 아이디
	private String noMemberPassword; // 비회원 비밀번호
	private String noMemberName; // 비회원 이름
	private String noMemberAccount; // 비회원 계좌번호

	private String noMemberAddress; // 비회원 주소

	private List<String> noMemberInventory;
	private int noMemberBalance;

	public NoMember(String noMemberId, String noMemberPassword, String noMemberName, String noMemberAccount,
			String noMemberAddress, List<String> noMemberInventory, int noMemberBalance) {
		super();
		this.noMemberId = noMemberId;
		this.noMemberPassword = noMemberPassword;
		this.noMemberName = noMemberName;
		this.noMemberAccount = noMemberAccount;
		this.noMemberAddress = noMemberAddress;
		this.noMemberInventory = noMemberInventory;
		this.noMemberBalance = noMemberBalance;
	}

	public String getNoMemberId() {
		return noMemberId;
	}

	public void setNoMemberId(String noMemberId) {
		this.noMemberId = noMemberId;
	}

	public String getNoMemberPassword() {
		return noMemberPassword;
	}

	public void setNoMemberPassword(String noMemberPassword) {
		this.noMemberPassword = noMemberPassword;
	}

	public String getNoMemberName() {
		return noMemberName;
	}

	public void setNoMemberName(String noMemberName) {
		this.noMemberName = noMemberName;
	}

	public String getNoMemberAccount() {
		return noMemberAccount;
	}

	public void setNoMemberAccount(String noMemberAccount) {
		this.noMemberAccount = noMemberAccount;
	}

	public String getNoMemberAddress() {
		return noMemberAddress;
	}

	public void setNoMemberAddress(String noMemberAddress) {
		this.noMemberAddress = noMemberAddress;
	}

	public List<String> getNoMemberInventory() {
		return noMemberInventory;
	}

	public void setNoMemberInventory(List<String> noMemberInventory) {
		this.noMemberInventory = noMemberInventory;
	}

	public int getNoMemberBalance() {
		return noMemberBalance;
	}

	public void setNoMemberBalance(int noMemberBalance) {
		this.noMemberBalance = noMemberBalance;
	}

}

// Product 클래스 
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

// 관리자 클래스 
class Admin {
	// 인스턴스 변수 정의
	private String adminId;
	private String adminPassword;

	// 생성자 정의
	public Admin(String adminId, String adminPassword) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	// Getter Setter
	public String getAdminId() {
		return adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}

// Payment 클래스 
class Payment {

}

// Delivery 클래스 
class Delivery {

}

// Order 클래스 
class Order {

}

// 회원 Controller 
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

	// 회원 로그인 로직
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

	// 회원 로그아웃 로직
	@Override
	public void logout() {
		System.out.println("==== 로그아웃 ====");
		System.out.println("See you again ^.^");
	}

	// 회원 정보 생성 로직
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
				inventory, balance);
		member.add(newMember);
	}

	// 회원 정보 삭제 로직
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

	// 회원 정보 수정 로직
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

	// 회원 정보 출력 로직
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

// 비회원 Controller 
class NoMemberController {

	private static NoMemberController instance;
	private ArrayList<NoMember> noMember;

	private NoMemberController() {
		noMember = new ArrayList<>();
	}

	public ArrayList<NoMember> getNoMembers() {
		return noMember;
	}

	public static NoMemberController getInstance() {
		if (instance == null) {
			instance = new NoMemberController();
		}
		return instance;
	}
}

// 상품 Controller 
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

// Payment Controller 
class PaymentController implements PaymentCrud, PaymentNoMemberCrud {

	private static PaymentController instance;
	private ArrayList<Payment> payments;
	private MemberController memberController;
	private NoMemberController noMemberController;
	private ProductController productController;

	private PaymentController() {
		payments = new ArrayList<>();
		memberController = MemberController.getInstance();
		productController = ProductController.getInstance();
		noMemberController = NoMemberController.getInstance();
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

	// 상품 가격 임의 설정
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

	// 회원 주문 로직
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

	// 회원 환불 로직
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

	// 회원 교환 로직
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

	// 비회원 주문 로직
	@Override
	public void orderProductNoMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 상품 주문 ====");
		System.out.println("아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();
		System.out.println("계좌번호를 입력하세요: ");
		String noMemberAccount = scan.nextLine();
		System.out.println("주소를 입력하세요: ");
		String noMemberAddress = scan.nextLine();
		System.out.println("보유 상품을 입력하세요: ");
		String noMemberInventoryInput = scan.nextLine();
		List<String> noMemberInventory = Arrays.asList(noMemberInventoryInput.split(",")); // added inventory property
		System.out.println("잔액을 입력하세요: ");
		int balance = scan.nextInt(); // added balance property
		scan.nextLine(); // consume the newline character

		NoMember noMember = new NoMember(noMemberId, noMemberPassword, noMemberAccount, noMemberAddress,
				noMemberInventoryInput, noMemberInventory, balance);
		noMemberController.getNoMembers().add(noMember);

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
			if (noMember.getNoMemberBalance() >= productPrice) {
				int newBalance = noMember.getNoMemberBalance() - productPrice;
				List<String> newInventory = new ArrayList<>(noMember.getNoMemberInventory());
				newInventory.add(productName);
				noMember.setNoMemberBalance(newBalance);
				noMember.setNoMemberInventory(newInventory);
				System.out.println("상품 주문이 완료되었습니다.");
				System.out.println("선택한 상품: " + productName);
				System.out.println("잔액: " + noMember.getNoMemberBalance());
				System.out.println("보유 상품: " + noMember.getNoMemberInventory());
			} else {
				System.out.println("상품 주문 실패: 잔액이 부족합니다.");
			}
		}
	}

	// 비회원 환불 로직
	@Override
	public void refundProductNoMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 비회원 환불 ===");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberRefundId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberRefundPassword = scan.nextLine();

		boolean notOk = true;
		for (NoMember noMember : noMemberController.getNoMembers()) {
			String noRefundId = noMember.getNoMemberId();
			String noRefundPassword = noMember.getNoMemberPassword();

			if (noRefundId.equals(noMemberRefundId) && noRefundPassword.equals(noMemberRefundPassword)) {
				notOk = false;
				System.out.println("환불할 상품을 선택하세요:");
				List<String> noMemberInventory = noMember.getNoMemberInventory();
				for (int i = 0; i < noMemberInventory.size(); i++) {
					System.out.println((i + 1) + ". " + noMemberInventory.get(i));
				}

				int productChoice = scan.nextInt();
				scan.nextLine(); // consume the newline character

				if (productChoice < 1 || productChoice > noMemberInventory.size()) {
					System.out.println("잘못된 상품 선택입니다.");
					return;
				}

				String productName = noMemberInventory.get(productChoice - 1);
				int productPrice = getProductPrice(productName); // helper method to get the price of the product

				List<String> newNoInventory = new ArrayList<>(noMemberInventory);
				newNoInventory.remove(productName);

				int newBalance = noMember.getNoMemberBalance() + productPrice;
				noMember.setNoMemberInventory(newNoInventory);
				noMember.setNoMemberBalance(newBalance);

				System.out.println("상품 환불이 완료되었습니다.");
				System.out.println("환불한 상품: " + productName);
				System.out.println("잔액: " + noMember.getNoMemberBalance());
				System.out.println("보유 상품: " + noMember.getNoMemberInventory());
				break;
			}
		}
		if (notOk) {
			System.out.println("상품 환불 실패: 잘못된 회원 정보입니다.");
		}
	}

	// 비회원 교환 로직
	@Override
	public void changeProductNoMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 비회원 상품 교환 ===");
		System.out.println("아이디를 입력하세요: ");
		String changeNoMemberId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String changeNoMemberPassword = scan.nextLine();

		boolean notOk = true;
		for (NoMember noMember : noMemberController.getNoMembers()) {
			String changeNoid = noMember.getNoMemberId();
			String changeNoPassword = noMember.getNoMemberPassword();
			boolean isOk = changeNoid.equals(changeNoid) && changeNoPassword.equals(changeNoPassword);
			if (isOk) {
				System.out.println("교환할 상품을 선택하세요: ");
				List<String> noMemberInveontory = noMember.getNoMemberInventory();
				for (int i = 0; i < noMemberInveontory.size(); i++) {
					System.out.println((i + 1) + ". " + noMemberInveontory.get(i));

					int oldProductChoice = scan.nextInt();
					scan.nextLine();
					if (oldProductChoice < 1 || oldProductChoice > noMemberInveontory.size()) {
						System.out.println("상품 교환 실패: 잘못된 상품 선택입니다.");
					} else {
						String oldProductName = noMemberInveontory.get(oldProductChoice - 1);

						System.out.println("새로운 상품을 선택하세요:");
						System.out.println("1. product1");
						System.out.println("2. product2");
						System.out.println("3. product3");
						System.out.println("4. product4");
						int newProductChoice = scan.nextInt();
						scan.nextLine();
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
							if (noMember.getNoMemberBalance() >= balanceDiff) {
								List<String> newInventory = new ArrayList<>(noMember.getNoMemberInventory());
								noMember.setNoMemberInventory(noMemberInveontory);
								noMember.setNoMemberBalance(balanceDiff);
								System.out.println("상품 교환이 완료되었습니다.");
								System.out.println("이전 상품: " + oldProductName);
								System.out.println("새로운 상품: " + newProductName);
								System.out.println("잔액: " + noMember.getNoMemberBalance());
								System.out.println("보유 상품: " + noMember.getNoMemberInventory());
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
	}
}

// 주문 Controller  
class OrderController implements OrderShowData {

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

// 배송 Controller 
class DeliveryController implements DeliveryFast {

	private static DeliveryController instance;
	private ArrayList<Delivery> deliveries;
	private MemberController memberController;
	private NoMemberController noMemberController;
	// 인스턴스 변수 선언 -> 하드코딩으로 배송 상태, 배송 날짜, 운송장 번호 추상 지정
	private String status;
	private String date;
	private String trackingNumber;

	// -> 하드코딩으로 비회원 배송 상태, 비회원 배송 날짜, 비회원 운송장 번호 추상 지정
	private String noMemberStatused;
	private String noMemberDated;
	private String noMemberTrackingNumber;

	private DeliveryController() {
		deliveries = new ArrayList<>();
		memberController = MemberController.getInstance();
		noMemberController = NoMemberController.getInstance();
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

	// 회원 배송 상태 로직
	@Override
	public void deliveryStatus() {
		// 배송 상태 설정
		status = "배송중";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 배송 상태 조회 ====");
		System.out.println("회원 아이디를 입력하세요: ");
		String id = scan.nextLine();
		System.out.println("회원 비밀번호를 입력하세요: ");
		String password = scan.nextLine();

		boolean notOk = true;
		for (Member memberStatus : memberController.getMembers()) {
			String memberId = memberStatus.getId();
			String memberPassword = memberStatus.getPassword();
			List<String> trackingPrice = memberStatus.getInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = memberId.equals(id) && memberPassword.equals(password)
					&& trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("배송 상태: " + status);
				notOk = false;
				break;
			}
			if (notOk) {
				System.out.println("회원 배송 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 회원 배송 날짜 로직
	@Override
	public void deliveryDate() {
		// 배송 날짜 설정
		date = "2023-04-15";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 회원 배송 날짜 조회 ====");
		System.out.println("아이디를 입력하세요: ");
		String idDate = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String passwordDate = scan.nextLine();

		boolean notOk = false;
		for (Member memberDate : memberController.getMembers()) {
			String memberDateId = memberDate.getId();
			String memberDatePassword = memberDate.getPassword();
			List<String> trackingPrice = memberDate.getInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = memberDateId.equals(idDate) && memberDatePassword.equals(passwordDate)
					&& trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("배송 날짜: " + date);
				notOk = true;
			}
			if (notOk) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 회원 운송장 번호 로직
	@Override
	public void deliveryTracking() {
		// 운송장 번호 설정
		trackingNumber = "12342-31234-23412";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 회원 운송장 번호 조회 ====");
		System.out.println("아이디를 입력하세요: ");
		String idTracking = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String passwordTracking = scan.nextLine();

		boolean notOk = false;
		for (Member memberTracking : memberController.getMembers()) {
			String trackingId = memberTracking.getId();
			String trackingPasswod = memberTracking.getPassword();
			List<String> trackingPrice = memberTracking.getInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = trackingId.equals(idTracking) && trackingPasswod.equals(passwordTracking)
					&& trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("회원 운송장 번호:" + trackingNumber);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("운송장 번호 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 배송 상태 로직
	@Override
	public void deliveryStatusNoMember() {
		// 비회원 배송 상태
		noMemberStatused = "배송중.";
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 비회원 배송 상태 조회 ===");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();

		boolean notOk = false;
		for (NoMember noMemberStatus : noMemberController.getNoMembers()) {
			String idNoMember = noMemberStatus.getNoMemberId();
			String passwordNoMember = noMemberStatus.getNoMemberPassword();
			List<String> trackingPrice = noMemberStatus.getNoMemberInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = idNoMember.equals(noMemberId) && passwordNoMember.equals(noMemberPassword)
					&& trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("회원 배송 상태:" + noMemberStatused);
				notOk = true;
				break;
			}
			if (notOk) {
				System.out.println("비회원 배송 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 배송 날짜 로직
	@Override
	public void deliveryDateNoMember() {
		// 배송 날짜 설정
		noMemberDated = "2023-04-23";
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 비회원 배송 날짜 조회 ===");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberDateId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberDatePassword = scan.nextLine();

		boolean notOk = false;
		for (NoMember noMemberDate : noMemberController.getNoMembers()) {
			String idNoDate = noMemberDate.getNoMemberId();
			String passwordNoDate = noMemberDate.getNoMemberPassword();
			List<String> trackingPrice = noMemberDate.getNoMemberInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = idNoDate.equals(noMemberDateId) && passwordNoDate.equals(noMemberDatePassword)
					&& trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("비회원 배송 날짜: " + noMemberDated);
				notOk = true;
				break;
			}
			if (notOk) {
				System.out.println("비회원 배송 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 운송장 번호 로직
	@Override
	public void deliveryTrackingNoMember() {
		// 운송장 번호 설정
		noMemberTrackingNumber = "12345-12345-12345";
		System.out.println("==== 회원 운송장 번호 조회 ====");
		Scanner scan = new Scanner(System.in);
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberTrackingId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberTrackingPassword = scan.nextLine();

		boolean notOk = false;
		for (NoMember noMemberTracking : noMemberController.getNoMembers()) {
			String idNoTracking = noMemberTracking.getNoMemberId();
			String passwordNoTracking = noMemberTracking.getNoMemberPassword();
			List<String> trackingPrice = noMemberTracking.getNoMemberInventory();

			if (trackingPrice == null) {
				System.out.println("회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
				return;
			}

			boolean isOk = idNoTracking.equals(noMemberTrackingId)
					&& passwordNoTracking.equals(noMemberTrackingPassword) && trackingPrice.equals(trackingPrice);
			if (isOk) {
				System.out.println("비회원 운송장 번호 조회:" + noMemberTrackingNumber);
				notOk = true;
				break;
			}
			if (notOk) {
				System.out.println("비회원 배송 조회 실패: 잘못된 입력입니다.");
			}
		}
	}
}

// 관리자 Controller 
class AdminController implements AdminManager {

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

// 회원 Crud interface 
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

// Payment interface 
interface PaymentCrud {

	// 회원 상품 주문
	public void orderProduct();

	// 회원 상품 환불
	public void refundProduct();

	// 회원 상품 교환
	public void changeProduct();

}

// paymentNoMember interface 
interface PaymentNoMemberCrud {

	// 비회원 상품 주문
	public void orderProductNoMember();

	// 비회원 상품 환불
	public void refundProductNoMember();

	// 비회원 상품 교환
	public void changeProductNoMember();
}

// Order interface 
interface OrderShowData {

	// 회원 주문 상태 출력
	public void memberOrderShowData();

	// 비회원 주문 상태 출력
	public void noMemberOrderShowData();
}

// Delivery interface 
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

// Admin interface 
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

// 메인 클래스 
class Main {
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