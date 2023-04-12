import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator
import java.util.List;
// 자바 2주차 자습 -> ToyProject // -> 싱글톤 패턴 연습 
// 내가 설계한 회원정보와 결제,환불,교환,비회원 주문 시스템 


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

	// 생성자 정의
	public Member(String name, String phoneNumber, String email, String address, String id, String password,
			String nickName, String noMemberId, String noMemberPassword, String noMemberName, String noMemberAccount,
			String memberAccount, String noMemberAddress) {
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

	public String inProudct() {
		return product1 + product2 + product3 + product4;
	}
}

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

// MemberController클래스 
class MemberController implements CurdOperation {

	private static MemberController instance;
	private ArrayList<Member> member;

	private MemberController() {
		member = new ArrayList<>();
	}

	public static MemberController getInstance() {
		if (instance == null) {
			instance = new MemberController();
		}
		return instance;
	}

	@Override
	// 로그인 로직
	public void login(String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 로그인 ====");
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();

		boolean notOk = false;
		for (Member loginMember : member) {
			String id2 = loginMember.getId();
			String password2 = loginMember.getPassword();

			boolean isOk = id1.equals(id1) && password2.equals(password2);
			System.out.println("로그인 완료");
			notOk = true;
			break;
		}
		if (!notOk) {
			System.out.println("로그인 실패: 아이디나 비밀번호를 확인해주세요.");
		}
	}

	@Override
	// 로그아웃 로직
	public void logout() {
		Scanner scan = new Scanner(System.in);
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

		Member newMember = new Member(name, phoneNumber, email, address, id, password, nickName, memberAccount, memberAccount, memberAccount, memberAccount, memberAccount, memberAccount);
		member.add(newMember);
	}

	// 회원 정보 삭제 로직
	@Override
	public void deleteMember(String name, String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 삭제 ===");
		System.out.println("이름을 입력하세요: ");
		String name3 = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String id3 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password3 = scan.nextLine();
		boolean notOk = false;
		for (Member deleteMember : member) {
			String deleteName = deleteMember.getName();
			String deleteId = deleteMember.getId();
			String deletePassword = deleteMember.getPassword();

			boolean isOk = deleteName.equals(name3) && deleteId.equals(id3) && deletePassword.equals(password3);
			if (isOk) {
				member.remove(deleteMember);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("잘못된 입력입니다 관리자에게 문의하세요. ");
			}
		}
	}

	// 회원 정보 수정 로직
	@Override
	public void modifyMember(String name, String id, String password, String memberAccount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원정보 수정 ===");
		System.out.println("이름을 입력하세요: ");
		String inputName = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String inputId = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String inputPassword = scan.nextLine();
		System.out.println("계좌번호를 입력하세요: ");
		String inputMemberAccount = scan.nextLine();
		boolean notOk = false;
		for (Member modifyMember : member) {
			String modifyName = modifyMember.getName();
			String modifyId = modifyMember.getId();
			String modifyPassword = modifyMember.getPassword();
			String modifyMemberAccount = modifyMember.getMemberAccount();

			boolean isOk = modifyName.equals(inputName) && modifyId.equals(inputId)
					&& modifyPassword.equals(inputPassword) && modifyMemberAccount.equals(inputMemberAccount);

			if (isOk) {
				System.out.println("new 이름 입력: ");
				String newName = scan.nextLine();
				System.out.println("new 전화번호 입력: ");
				String newPhoneNumber = scan.nextLine();
				System.out.println("new 이메일 입력: ");
				String newEmail = scan.nextLine();
				System.out.println("new 주소 입력: ");
				String newAddress = scan.nextLine();
				System.out.println("new 아이디 입력: ");
				String newId = scan.nextLine();
				System.out.println("new password 입력: ");
				String newPassoword = scan.nextLine();
				System.out.println("new 닉네임 입력: ");
				String newNickName = scan.nextLine();
				System.out.println("new 계좌번호 입력: ");
				String newMemberAccount = scan.nextLine();

				Member modifyMember = new Member(newName, newPhoneNumber, newEmail, newAddress, newId, newPassoword,
						newNickName, newMemberAccount);
				member.set(modifyMember);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("잘못된 입력입니다 관리자에게 문의하세요.");
			}
		}
	}

	// 회원 정보 출력 로직
	@Override
	public void showDataMember(String name, String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 정보 출력 ===");
		System.out.println("이름을 입력하세요: ");
		String name1 = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();
		boolean showData = false;
		for (Member showMember : member) {
			String showName = showMember.getName();
			String showId = showMember.getId();
			String showPasword = showMember.getPassword();

			boolean isOk = showName.equals(name1) && showId.equals(id1) && showPasword.equals(password1);

			if (isOk) {
				System.out.println(showMember.getName());
				System.out.println(showMember.getPhoneNumber());
				System.out.println(showMember.getEmail());
				System.out.println(showMember.getId());
				System.out.println(showMember.getPassword());
				System.out.println(showMember.getNickName());
				System.out.println(showMember.getMemberAccount());
				showData = true;
				break;
			}
			if (!showData) {
				System.out.println("잘못된 입력입니다 관리자에게 문의하세요.");
			}
		}
	}
}

// ProductController 클래스 
class ProductController {
	private static ProductController instance;
	private ArrayList<Product> products;

	private ProductController() {
		products = new ArrayList<>();
	}

	public static ProductController getInstance() {
		if (instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
}

// PaymentController 클래스 
class PaymentController implements Payment {

	private static PaymentController instance;
	private ArrayList<PaymentController> paymentController;
	private MemberController memberController;
	private ProductController productController;

	private PaymentController() {
		memberController = MemberController.getInstance();
		productController = ProductController.getInstance();
		paymentController = new ArrayList<>();
	}

	public static PaymentController getInstance() {
		if (instance == null) {
			instance = new PaymentController();
		}
		return instance;
	}

	// 상품 환불 로직
	@Override
	public void refundProduct(String name, String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 상품 환불 ===");
		System.out.println("이름을 입력하세요: ");
		String name1 = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();

		MemberController refundMember = memberController.getInstance();
		boolean notOk = false;
		for (Member member : memberController.member) {
			String refundName = member.getName();
			String refundId = member.getId();
			String refundPassword = member.getPassword();

			boolean isOk = refundName.equals(name1) && refundId.equals(id1) && refundPassword.equals(password1);
			if (isOk) {
				ProductController refundProduct = ProductController.getInstance();
				System.out.println("환불할 상품 선택: ");
				String product = scan.nextLine();
				for (Product p : ProductController.products) {
					String productChoose = p.inProudct();
					if (productChoose.equalsIgnoreCase(product)) {
						System.out.println("환불이 완료되었습니다.");
						notOk = true;
						break;

					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("환불 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

	// 상품 주문 로직
	@Override
	public void orderProduct(String name, String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 상품 주문 ====");
		System.out.println("이름을 입력하세요: ");
		String name1 = scan.nextLine();
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();

		MemberController ordermember = memberController.getInstance();
		boolean notOk = false;
		for (Member member : memberController.member) {
			String orderName = member.getName();
			String orderId = member.getId();
			String orderPassword = member.getPassword();

			boolean isOk = orderName.equals(name1) && orderId.equals(id1) && orderPassword.equals(password1);
			if (isOk) {
				System.out.println("상품 주문 입니다.");
				System.out.println("상품을 선택하세요: ");
				String productChoose = scan.nextLine();
				ProductController order = ProductController.getInstance();
				for (Product product : ProductController.products) {
					String inchoose = product.inProudct();
					if (inchoose.equalsIgnoreCase(product)) {
						System.out.println("상품 주문이 완료되었습니다.");
						notOk = true;
						break;
					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("상품 주문 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

	// 상품 교환 로직
	@Override
	public void changeProduct(String name, String id, String password) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 상품 교환 ====");
		System.out.println("이름을 입력하세요: ");
		String noMemberName = scan.nextLine();
		System.out.println("비회원 ID를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();

		Member changeProduct = memberController.getInstance();
		boolean notOk = false;
		for (Member member : memberController.member) {
			String changeName = member.getName();
			String changeId = member.getId();
			String changePassword = member.getPassword();
			boolean isOk = changeName.equals(name) && changeId.equals(id) && changePassword.equals(password);
			if (isOk) {
				System.out.println("상품 교환 입니다.");
				System.out.println("상품을 선택하세요: ");
				String changeProudct = scan.nextLine();
				for (Product product : ProductController.products) {
					String inChoose = product.inProudct();
					if (inChoose.equalsIgnoreCase(product)) {
						System.out.println("교환 주문이 완료되었습니다.");
						notOk = true;
						break;
					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("상품 교환 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

	// 비회원 환불 로직
	@Override
	public void refundProductNoMember(String noMemberName, String noMemberId, String noMemberPassword,
			String noMemberAccount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 상품 환불 ====");

		Member noMember = new memberController.getInstance();
		boolean notOk = false;
		for (Member noMember1 : memberController.member) {
			String noName = noMember1.getNoMemberName();
			String noId = noMember1.getNoMemberId();
			String noPassword = noMember1.getNoMemberPassword();
			String noMemberAccount1 = noMember1.getNoMemberAccount();

			boolean isOk = noName.equals(noMemberName) && noId.equals(noMemberId) && noPassword.equals(noMemberPassword)
					&& noMemberAccount1.equals(noMemberAccount1);
			if (isOk) {
				System.out.println("비회원 환불 입니다.");
				System.out.println("상품을 선택하세요.");
				String inChoose = scan.nextLine();
				for (Product product : ProductController.products) {
					String inChoose1 = product.inProudct();
					if (inChoose1.equals(product)) {
						System.out.println("비회원 상품 환불이 완료되었습니다.");
						notOk = true;
						break;
					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("상품 비회원 주문 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

	// 비회원 주문 로직
	@Override
	public void orderProductNoMember(String noMemberId, String noMemberPassword, String noMemberName,
			String noMemberAccount, String noMemberAddress) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 주문 ====");

		Member noMember = new memberController.getInstance();
		boolean notOk = false;
		for (Member noMember1 : memberController.member) {
			String noName = noMember1.getNoMemberName();
			String noId = noMember1.getNoMemberId();
			String noPassword = noMember1.getNoMemberPassword();
			String noMemberAccount1 = noMember1.getNoMemberAccount();
			String noMemberAddress1 = noMember1.getNoMemberAddress();

			boolean isOk = noName.equals(noMemberName) && noId.equals(noMemberId) && noPassword.equals(noMemberPassword)
					&& noMemberAccount1.equals(noMemberAccount1) && noMemberAddress1.equals(noMemberAddress1);
			if (isOk) {
				System.out.println("비회원 상품 주문 입니다.");
				System.out.println("상품을 선택하세요.");

				String inChoose = scan.nextLine();
				for (Product product : ProductController.products) {
					String inChoose1 = product.inProudct();
					if (inChoose1.equals(product)) {
						System.out.println("비회원 상품 주문이 완료되었습니다.");
						notOk = true;
						break;
					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("상품 비회원 주문 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

	// 비회원 교환 로직
	@Override
	public void changePrdouctNoMember(String noMemberName, String noMemberId, String noMemberPassword) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 교환 ====");

		Member noMember = new memberController.getInstance();
		boolean notOk = false;
		for (Member noMember1 : memberController.member) {
			String noName = noMember1.getNoMemberName();
			String noId = noMember1.getNoMemberId();
			String noPassword = noMember1.getNoMemberPassword();

			boolean isOk = noName.equals(noMemberName) && noId.equals(noMemberId)
					&& noPassword.equals(noMemberPassword);
			if (isOk) {
				System.out.println("비회원 상품 교환 입니다.");
				System.out.println("상품을 선택하세요.");
				String inChoose = scan.nextLine();
				for (Product product : ProductController.products) {
					String inChoose1 = product.inProudct();
					if (inChoose1.equals(product)) {
						System.out.println("비회원 상품 교환이 완료되었습니다.");
						notOk = true;
						break;
					}
				}
				if (notOk)
					break;
			}
			if (!notOk) {
				System.out.println("상품 비회원 주문 실패: 잘못된 회원 정보이거나 상품 정보입니다.");
			}
		}
	}

}

// DelivertController 클래스 
class DeliveryController implements DeliveryFast {

	// 인스턴스 변수 선언 -> 하드코딩으로 배송 상태, 배송 날짜, 운송장 번호 추상 지정
	private String status;
	private String date;
	private String trackingNumber;

	// -> 하드코딩으로 비회원 배송 상태, 비회원 배송 날짜, 비회원 운송장 번호 추상 지정
	private String noMemberStatus;
	private String noMemberDate;
	private String noMemberTrackingNumber;

	private static DeliveryController instance;
	private ArrayList<DeliveryController> deliveryController;
	private MemberController memberController;
	private ProductController productController;
	private PaymentController paymentController;

	private public DeliveryController() {
		deliveryController = new ArrayList<>();
		memberController.getInstance();
		ProductController.getInstance();
		paymentController.getInstance();
	}

	public static DeliveryController getInstance() {
		if (instance == null) {
			instance = new DeliveryController();
		}
		return instance;
	}

	// 회원 배송 상태 로직
	@Override
	public void deliveryStatus(String id, String password) {
		// 배송 상태 설정
		status = "배송중";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 배송 상태 조회 ====");
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();

		boolean notOk = false;
		Member memberStatus = new memberController.getInstance();
		for (Member memberStatus1 : memberController.member) {
			String id2 = memberStatus1.getId();
			String password2 = memberStatus1.getPassword();

			boolean isOk = id1.equals(id2) && password1.equals(password2);
			if (isOk) {
				System.out.println("배송 상태:" + status);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("배송 상태 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 회원 배송 날짜 로직
	@Override
	public void deliveryDate(String id, String password) {
		// 배송 날짜 설정
		date = "2023-04-15";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 배송 날짜 조회 ====");
		System.out.println("아이디를 입력하세요: ");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요: ");
		String password1 = scan.nextLine();

		boolean notOk = false;
		Member memberDate = new memberController.getInstance();
		for (Member meberDate : memberController.member) {
			String id = memberDate.getId();
			String password = memberDate.getPassword();

			boolean isOk = id.equals(id) && password.equals(password);
			if (isOk) {
				System.out.println("배송 날짜:" + date);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("배송 날짜 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 회원 운송장 번호 조회 로직
	@Override
	public void deliveryTracking(String id, String password) {
		// 운송장 번호 설정
		trackingNumber = "123452-234253-234235";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 운송장 번호 조회 ====");
		System.out.println("아이디를 입력하세요");
		String id1 = scan.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String password1 = scan.nextLine();

		boolean notOk = false;
		Member memberTracking = new MemberController.getInstance();
		for (Member memberTracking1 : memberController.member) {
			String id = memberTracking1.getId();
			String password = memberTracking1.getPassword();

			boolean isOk = id.equals(id) && password.equals(password);
			if (isOk) {
				System.out.println("운송장 번호:" + trackingNumber);
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
	public void deliveryStatusNoMember(String noMemberId, String noMemberPassword) {
		// 비회원 배송 상태
		noMemberStatus = "배송중";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 배송 조회 ====");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();

		boolean notOk = false;
		Member memberStatus = new memberController.getInstance();
		for (Member memberStatus : memberController.member) {
			String noMemberId = memberStatus.getNoMemberId();
			String noMemberPassword = memberStatus.getNoMemberPassword();

			boolean isOk = noMemberId.equals(noMemberId) && noMemberPassword.equals(noMemberPassword);
			if (isOk) {
				System.out.println("비회원 배송 상태:" + noMemberStatus);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("비회원 배송 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 배송 날짜 로직
	@Override
	public void deliveryDateNoMember(String noMemberId, String noMemberPassword) {
		// 비회원 배송 날짜
		noMemberDate = "2023-05-15";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 배송 날짜 조회 ====");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();

		boolean notOk = false;
		Member memberDate = new memberController.getInstance();
		for (Member memberDate : memberController.member) {
			String noMemberId = memberDate.getNoMemberId();
			String noMemberPassword = memberDate.getNoMemberPassword();

			boolean isOk = noMemberId.equals(noMemberId) && noMemberPassword.equals(noMemberPassword);
			if (isOk) {
				System.out.println("비회원 배송 상태:" + noMemberDate);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("비회원 배송 날짜 조회 실패: 잘못된 입력입니다.");
			}
		}
	}

	// 비회원 운송장 번호 조회 로직
	@Override
	public void deliveryTrackingNoMember(String noMemberId, String noMemberPassword) {
		// 운송장 번호 조회
		noMemberTrackingNumber = "123452-234253-234235";
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 비회원 운송장 번호 조회 ====");
		System.out.println("비회원 아이디를 입력하세요: ");
		String noMemberId = scan.nextLine();
		System.out.println("비회원 비밀번호를 입력하세요: ");
		String noMemberPassword = scan.nextLine();

		boolean notOk = false;
		Member memberTracking = new memberController.getInstance();
		for (Member memberTracking : memberController.member) {
			String noMemberId = memberTracking.getNoMemberId();
			String noMemberPassword = memberTracking.getNoMemberPassword();

			boolean isOk = noMemberId.equals(noMemberId) && noMemberPassword.equals(noMemberPassword);
			if (isOk) {
				System.out.println("비회원 운송장 번호:" + noMemberTrackingNumber);
				notOk = true;
				break;
			}
			if (!notOk) {
				System.out.println("비회원 운송잔 번호 조회 실패: 잘못된 입력입니다.");
			}
		}
	}
}

class AdminController implements AdminManager {

	private static AdminController instance;
	private ArrayList<AdminController> adminController;
	private MemberController memberController;
	private DeliveryController deliveryController;
	private PaymentController paymentController;
	private ArrayList<Admin> admin;

	private AdminController() {

		adminController = new ArrayList<>();
		memberController = MemberController.getInstance();
		deliveryController = DeliveryController.getInstance();
		paymentController = PaymentController.getInstance();
	}

	public static AdminController getInstance() {
		if (instance == null) {
			instance = new AdminController();
		}
		return instance;
	}

	// 관리자 로그인 로직
	@Override
	public void adminLogin(String adminId, String adminPassword) {

		boolean notOk = false;
		for (Admin admins : AdminController.getInstance()) {
			String adminId = admins.getAdminId();
			String adminPassword = admins.getAdminPassword();

			boolean isOk = adminId.equals(adminId) && adminPassword.equals(adminPassword);
			if (isOk) {
				System.out.println("로그인 성공");
				notOk = true;
				break;
			}
		}
		if (!notOk) {
			System.out.println("관리자 로그인 실패: 잘못된 입력입니다.");
		}

	}

	// 관리자 로그아웃
	@Override
	public void adminLogout() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 로그아웃 ====");
		System.out.println("See you again ^.^");
	}

	// 회원 목록 조회
	@Override
	public void memberShowData(String adminId, String adminPassword) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 회원 목록 조회 ====");
		System.out.println("관리자 아이디를 입력하세요: ");
		String adminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String adminPassword = scan.nextLine();

		boolean notOk = false;
		for (Admin admins : AdminController.getInstance()) {
			String adminId = admins.getAdminId();
			String adminPassword = admins.getAdminPassword();

			boolean isOk = adminId.equals(adminId) && adminPassword.equals(adminPassword);
			if (isOk) {
				System.out.println("회원 목록 조회");
				System.out.println("회원 이름을 입력하세요: ");
				String name = scan.nextLine();
				for (Member member : memberController.member) {
					if (member.getName().equals(name)) {
						System.out.println(member.getName());
						System.out.println(member.getPhoneNumber());
						System.out.println(member.getEmail());
						System.out.println(member.getId());
						System.out.println(member.getPassword());
						System.out.println(member.getNickName());
						System.out.println(member.getMemberAccount());
						notOk = true;
						break;
					}
				}
			}
			if (notOk)
				break;
		}
		if (!notOk) {
			System.out.println("회원 목록 조회 실패: 잘못된 입력입니다.");
		}
	}

	// 회원 정보 수정
	@Override
	public void memberModify(String adminId, String adminPassword) {
		Scanner scan = new Scanner(System.in);
		System.out.println("====관리자 전용 회원 정보 수정====");
		System.out.println("관리자 아이디를 입력하세요: ");
		String id = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String password = scan.nextLine();

		boolean notOk = false;
		for (Admin admins : AdminController.getInstance()) {
			String adminId = admins.getAdminId();
			String adminPassword = admins.getAdminPassword();

			boolean isOk = adminId.equals(adminId) && adminPassword.equals(adminPassword);
			if (isOk) {
				System.out.println("정보를 수정할 회원 이름을 입력하세요: ");
				String memberName = scan.nextLine();
				for (Member member : memberController.member) {
					if (member.getName().equals(memberName)) {
						System.out.println("new 이름 입력: ");
						String newName = scan.nextLine();
						System.out.println("new 전화번호 입력: ");
						String newPhoneNumber = scan.nextLine();
						System.out.println("new 이메일 입력: ");
						String newEmail = scan.nextLine();
						System.out.println("new 주소 입력: ");
						String newAddress = scan.nextLine();
						System.out.println("new 아이디 입력: ");
						String newId = scan.nextLine();
						System.out.println("new password 입력: ");
						String newPassword = scan.nextLine();
						System.out.println("new 닉네임 입력: ");
						String newNickName = scan.nextLine();
						System.out.println("new 계좌번호 입력: ");
						String newMemberAccount = scan.nextLine();

						member.setName(newName);
						member.setPhoneNumber(newPhoneNumber);
						member.setEmail(newEmail);
						member.setAddress(newAddress);
						member.setId(newId);
						member.setPassword(newPassword);
						member.setNickName(newNickName);
						member.setMemberAccount(newMemberAccount);

						notOk = true;
						break;
					}
				}
				if (notOk) {
					break;
				}
			}
		}
		if (!notOk) {
			System.out.println("회원 정보 수정 실패: 잘못된 입력입니다.");
		}
	}

	// 회원 삭제
	@Override
	public void memberDelete(String adminId, String adminPassword) {
		Scanner scan = new Scanner(System.in);
		System.out.println("==== 관리자 전용 회원 삭제 ====");
		System.out.println("관리자 아이디를 입력하세요: ");
		String deleteAdminId = scan.nextLine();
		System.out.println("관리자 비밀번호를 입력하세요: ");
		String deleteAdminPassword = scan.nextLine();

		boolean notOk = false;
		for (Admin admins : AdminController.getInstance()) {
			String adminId = admins.getAdminId();
			String adminPassword = admins.getAdminPassword();

			boolean isOk = deleteAdminId.equals(adminId) && deleteAdminPassword.equals(adminPassword);
			if (isOk) {
				System.out.println("삭제할 회원의 이름을 입력하세요");
				String memberName = scan.nextLine();
				Iterator<Member> iterator = memberController.member.iterator();
				while (iterator.hasNext()) {
					Member member = iterator.next();
					if (member.getName().equals(memberName)) {
						iterator.remove();
						System.out.println("회원 정보 삭제 완료");
						notOk = true;
						break;
					}
				}
			}
			if (notOk) {
				break;
			}

		}
		if (!notOk) {
			System.out.println("회원 정보 삭제 실패: 잘못된 입력입니다.");

		}
	}
}

// Curd 메소드 interface  
interface CurdOperation {
	// 로그인
	public void login(String id, String password);

	// 로그아웃
	public void logout();

	// 회원 정보 생성
	public void createMember();

	// 회원 정보 삭제
	public void deleteMember(String name, String id, String password);

	// 회원 정보 수정
	public void modifyMember(String name, String id, String password, String memberAccount);

	// 회원 정보 출력
	public void showDataMember(String name, String id, String password);
}

// payment interface 
interface Payment {
	// 상품 환불
	public void refundProduct(String name, String id, String password);

	// 상품 주문
	public void orderProduct(String name, String id, String password);

	// 상품 교환
	public void changeProduct(String name, String id, String password);

	// 비회원 환불
	public void refundProductNoMember(String noMemberName, String noMemberId, String noMemberPassowrd,
			String noMemberAccount);

	// 비회원 교환
	public void changePrdouctNoMember(String noMemberName, String noMemberId, String noMemberPassword);

	// 비회원 주문
	public void orderProductNoMember(String noMemberName, String noMemberId, String noMemberPassword,
			String noMemberAccount, String noMemberAddress);
}

// Delivery interface 
interface DeliveryFast {

	// 회원 배송 상태 조회
	public void deliveryStatus(String id, String password);

	// 회원 배송 날짜 조회
	public void deliveryDate(String id, String password);

	// 회원 운송장 번호 조회
	public void deliveryTracking(String id, String password);

	// 비회원 배송 상태 조회
	public void deliveryStatusNoMember(String noMemberId, String noMemberPassword);

	// 비회원 배송 날짜 조회
	public void deliveryDateNoMember(String noMemberId, String noMemberPassword);

	// 비회원 운송장 번호 조회
	public void deliveryTrackingNoMember(String noMemberId, String noMemberPassword);

}

interface AdminManager {

	// 관리자 로그인
	public void adminLogin(String adminId, String adminPassword);

	// 관리자 로그아웃
	public void adminLogout();

	// 관리자 회원 목록 조회
	public void memberShowData(String adminId, String adminPassword);

	// 관리자 회원 정보 수정
	public void memberModify(String adminId, String adminPassword);

	// 관리자 회원 삭제
	public void memberDelete(String adminId, String adminPassword);

}

// try catch 클래스 
class ExceptionManager {

	public static void handlingException(Exception e) {
		System.out.println("예외 발생 관리자에게 문의하세요" + e.getMessage());

	}
}

// Main클래스 
class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = MemberController.getInstance();
		PaymentController paymentController = PaymentController.getInstance();
		DeliveryController deliveryController = DeliveryController.getInstance();
		AdminController adminCountroller = AdminController.getInstance();

		while (true) {
			try {
				System.out.println("===== 메뉴 선택 =====");
				System.out.println("1.  회원가입");
				System.out.println("2.  회원정보 출력");
				System.out.println("3.  회원정보 수정");
				System.out.println("4.  회원 삭제");
				System.out.println("5.  상품 주문");
				System.out.println("6.  상품 환불");
				System.out.println("7.  상품 교환");
				System.out.println("8.  비회원 환불");
				System.out.println("9.  비회원 교환");
				System.out.println("10. 비회원 주문");
				System.out.println("11. 로그인");
				System.out.println("12. 로그아웃");
				System.out.println("13. 회원 배송 조회");
				System.out.println("14. 회원 배송 날짜 조회");
				System.out.println("15. 회원 운송장 번호 조회");
				System.out.println("16. 비회원 배송 조회");
				System.out.println("17. 비회원 배송 날짜 조회");
				System.out.println("18. 비회원 운송장 번호 조회");
				System.out.println("19. 관리자 로그인");
				System.out.println("20. 관리자 로그아웃");
				System.out.println("21. 관리자 회원 목록 조회");
				System.out.println("22. 관리자 회원 정보 수정");
				System.out.println("23. 관리자 회원 삭제");
				System.out.println("24. 종료");
				System.out.print("메뉴를 선택하세요: ");
				int choice = scan.nextInt();
				scan.nextLine(); // 입력 버퍼를 비웁니다.

				switch (choice) {
				case 1:
					memberController.createMember();
					break;
				case 2:
					System.out.println("이름을 입력하세요: ");
					String name = scan.nextLine();
					System.out.println("아이디를 입력하세요: ");
					String id = scan.nextLine();
					System.out.println("비밀번호를 입력하세요: ");
					String password = scan.nextLine();
					memberController.showDataMember(name, id, password);
					break;
				case 3:
					memberController.modifyMember(name, id, password, memberAccount);
					break;
				case 4:
					memberController.deleteMember(name, id, password);
					break;
				case 5:
					paymentController.orderProduct(name, id, password);
					break;
				case 6:
					paymentController.refundProduct(name, id, password);
					break;
				case 7:
					paymentController.changeProduct(name, id, password);
					break;
				case 8:
					System.out.println("이름을 입력하세요: ");
					String noMemberName = scan.nextLine();
					System.out.println("비회원 Id를 입력하세요: ");
					String noMemberId = scan.nextLine();
					System.out.println("비회원 비밀번호를 입력하세요: ");
					String noMemberPassword = scan.nextLine();
					System.out.println("비회원 계좌번호를 입력하세요: ");
					String noMemberAccount = scan.nextLine();
					paymentController.refundProductNoMember(noMemberId, noMemberPassword, noMemberName,
							noMemberAccount);
					break;
				case 9:
					paymentController.changeProduct(noMemberId, noMemberPassword, noMemberName);
					break;
				case 10:
					System.out.println("이름을 입력하세요: ");
					String noMemberName1 = scan.nextLine();
					System.out.println("비회원 ID를 입력하세요: ");
					String noMemberId1 = scan.nextLine();
					System.out.println("비회원 비밀번호를 입력하세요: ");
					String noMemberPassword1 = scan.nextLine();
					System.out.println("비회원 계좌번호를 입력하세요: ");
					String noMemberAccount1 = scan.nextLine();
					System.out.println("비회원 주소를 입력하세요: ");
					String noMemberAddress = scan.nextLine();
					paymentController.orderProductNoMember(noMemberId1, noMemberPassword1, noMemberName1, noMemberAccount1,
							noMemberAddress);
					break;
				case 11:
					memberController.login(id, password);
					break;
				case 12:
					memberController.logout();
					break;
				case 13:
					deliveryController.deliveryStatus(id, password);
					break;
				case 14:
					deliveryController.deliveryDate(id, password);
					break;
				case 15:
					deliveryController.deliveryTracking(id, password);
					break;
				case 16:
					deliveryController.deliveryStatusNoMember(noMemberId1, noMemberPassword1);
					break;
				case 17:
					deliveryController.deliveryDateNoMember(noMemberId1, noMemberPassword1);
					break;
				case 18:
					deliveryController.deliveryTrackingNoMember(noMemberId1, noMemberPassword1);
					break;
				case 19:
					System.out.println("==== 회원 목록 조회 ====");
					System.out.println("관리자 아이디를 입력하세요: ");
					String adminId = scan.nextLine();
					System.out.println("관리자 비밀번호를 입력하세요: ");
					String adminPassword = scan.nextLine();
					adminCountroller.adminLogin(adminId, adminPassword);
					break;
				case 20:
					adminCountroller.adminLogout();
					break;
				case 21:
					System.out.print("관리자 아이디를 입력하세요: ");
					String showAdminId = scan.nextLine();
					System.out.print("관리자 비밀번호를 입력하세요: ");
					String showAdminPassword = scan.nextLine();
					adminCountroller.memberShowData(showAdminId, showAdminPassword);
					break;
				case 22:
					System.out.print("관리자 아이디를 입력하세요: ");
					String modifyAdminId = scan.nextLine();
					System.out.print("관리자 비밀번호를 입력하세요: ");
					String modifyAdminPassword = scan.nextLine();
					adminCountroller.memberModify(modifyAdminId, modifyAdminPassword);
					break;
				case 23:
					System.out.print("관리자 아이디를 입력하세요: ");
					String deleteAdminId = scan.nextLine();
					System.out.print("관리자 비밀번호를 입력하세요: ");
					String deleteAdminPassword = scan.nextLine();
					adminCountroller.memberDelete(deleteAdminId, deleteAdminPassword);
					break;
				case 24:
					System.out.println("프로그램을 종료합니다.");
					scan.close();
					return;
				default:
					System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
					break;
				}
			} catch (Exception e) {
				ExceptionManager.handlingException(e);
			}
		}
	}
}

