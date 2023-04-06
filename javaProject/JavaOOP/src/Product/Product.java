package Product;

import java.util.ArrayList;
import java.util.Scanner;

//온라인 주문 시스템을 구현하는데 필요한 클래스, 변수, 메소드 등을 고려해보겠습니다.

//클래스:
//Product: 상품 정보를 담는 클래스. 상품명, 가격, 재고 등의 정보를 갖는다.
//Cart: 장바구니 정보를 담는 클래스. 담긴 상품과 수량 정보를 갖는다.
//Order: 주문 정보를 담는 클래스. 주문한 상품과 수량, 결제 금액 등의 정보를 갖는다.
//OrderManager: 주문 정보를 관리하는 클래스. 새로운 주문 생성, 주문 취소, 결제 처리 등의 기능을 갖는다.

//변수:
//productList: 등록된 상품 리스트를 담는 변수.
//cartList: 장바구니에 담긴 상품 리스트를 담는 변수.
//orderList: 생성된 주문 리스트를 담는 변수.

//메소드:
//Product 클래스: 상품 등록, 수정, 삭제 기능을 갖는 메소드를 구현한다.
//Cart 클래스: 상품을 장바구니에 추가하고, 수량을 변경하거나 제거하는 메소드를 구현한다.
//Order 클래스: 주문 생성, 결제 처리, 취소 기능을 갖는 메소드를 구현한다.
//OrderManager 클래스: 새로운 주문 생성, 주문 취소, 결제 처리, 주문 내역 조회 등의 기능을 구현한다.

//라이브러리:
//JDBC: 데이터베이스와 연동하여 상품, 장바구니, 주문 정보를 저장하고 관리하는 기능을 구현한다.
//Servlet, JSP: 웹 기반으로 구현할 경우, 클라이언트와 서버 간의 요청과 응답 처리를 위한 라이브러리를 활용한다.
//Jackson, Gson 등의 JSON 라이브러리: 웹 기반으로 구현할 경우, 데이터를 JSON 형식으로 처리하는 기능을 구현한다.
//이러한 클래스, 변수, 메소드, 라이브러리를 활용하여 온라인 주문 시스템을 구현할 수 있습니다.

// 상품 클래스 정의 
public class Product {

	// 인스턴스 변수 정의
	private String productName; // 상품 이름
	private String productPrice; // 상품 가격
	private String productStock; // 상품 재고

	// 생성자 정의
	public Product(String productName, String productPrice, String productStock) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	// Getter Setter 정의
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStock() {
		return productStock;
	}

	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}

	// 추상 메소드 정의
	public void printinfo() {
		System.out.println("상품 명: " + productName);
		System.out.println("상품 가격: " + productPrice);
		System.out.println("상품 재고: " + productStock);
	}
}

// 장바구니 클래스 정의 
class Cart extends Product {

	// 인스턴스 변수 정의
	private String product; // 상품
	private String productInformation; // 상품 정보

	// 생성자 정의
	public Cart(String productName, String prodcutPrice, String productStock, String product,
			String productInformation) {
		super(productName, prodcutPrice, productStock);
		this.product = product;
		this.productInformation = productInformation;
	}

	// Getter Setter
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductInformaiton() {
		return productInformation;
	}

	public void setProductInformaiton(String productInformation) {
		this.productInformation = productInformation;
	}

	// 추상 메소드 오버라이딩
	public void productInfo() {
		super.printinfo();
		System.out.println(product);
		System.out.println(productInformation);
	}
}

// 주문 클래스 정의 
class Order extends Product {

	// 인스턴스 변수 정의
	private String orderedPrice; // 상품 결제
	private String paymentAmount; // 결제 금액
	private String paymentPurpose; // 결제 용도
	private String refundProduct; // 상품 환불

	// 생성자 정의
	public Order(String productName, String prodcutPrice, String productStock, String orderedPrice,
			String paymentAmount, String paymentPurpose, String refundProduct) {
		super(productName, prodcutPrice, productStock);
		this.orderedPrice = orderedPrice;
		this.paymentAmount = paymentAmount;
		this.refundProduct = refundProduct;
	}

	// Getter Setter
	public String getOrderedPrice() {
		return orderedPrice;
	}

	public void setOrderedPrice(String orderedPrice) {
		this.orderedPrice = orderedPrice;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentPurpose() {
		return paymentPurpose;
	}

	public void setPaymentPurpose() {
		this.paymentAmount = paymentPurpose;
	}

	public String getRefundProduct() {
		return refundProduct;
	}

	public void setRefundProduct(String refundProduct) {
		this.refundProduct = refundProduct;
	}

	// 추상 메소드 오버라이딩
	public void orderInfo() {
		super.printinfo();
		System.out.println(orderedPrice);
		System.out.println(paymentAmount);
		System.out.println(refundProduct);
	}
}

// Crud 쇼핑몰 클래스 정의 
interface ShoppingMallCrud {

	// 카트 정보 생성
	public static void createCart() {
	}

	// 카트 정보 삭제
	public static void deleteCart() {
	}

	// 카트 정보 수정
	public static void modifyCart() {
	}

	// 카트 정보 출력
	public static void showDatacart() {
	}

	// 오더 정보 생성
	public static void createOrder() {
	}

	// 오더 정보 삭제
	public static void deleteOrder() {
	}

	// 오더 정보 수정
	public static void modifyOrder() {
	}

	// 오더 정보 출력
	public static void showDataOrder() {
	}
}

// Crud 회원 정보 클래스 정의 
interface Membercurd {

}

// 예외 처리 클래스 정의 
class ExceptionHelper2 {
	public static void handleException(Exception e) {

		// 예외처리 로직 구현
		System.out.println("확인되지 않은 입력입니다. 관리자에게 문의해주세요.>>" + e.getMessage());

	}
}

class Main2 implements ShoppingMallCrud {

	// ArrayList 생성
	private static ArrayList<Cart> cartList = new ArrayList<>();
	private static ArrayList<Order> orderList = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean istrue = true;
		while (true) {
			try {
				System.out.println("==== 쇼핑몰 관리 프로그램 (1~4) ====");
				System.out.println("==== 쇼핑몰 결제 프로그램 (5~8) ====");
				System.out.println("1. 장바구니 정보 생성");
				System.out.println("2. 장바구니 정보 삭제");
				System.out.println("3. 장바구니 정보 수정");
				System.out.println("4. 장바구니 정보 출력");
				System.out.println("======================");
				System.out.println("5. 주문 정보 생성");
				System.out.println("6. 주문 정보 삭제");
				System.out.println("7. 주문 정보 수정");
				System.out.println("8. 주문 정보 출력");
				System.out.println("======================");
				System.out.println("9.종료 ^^");
				System.out.println("원하는 동작 선택 (1~9)");
				int choice = scan.nextInt();
				scan.nextLine();

				switch (choice) {
				case 1:
					createCart();
					break;
				case 2:
					deleteCart();
					break;
				case 3:
					modifyCart();
					break;
				case 4:
					showDataCart();
					break;
				case 5:
					createOrder();
					break;
				case 6:
					deleteOrder();
					break;
				case 7:
					modifyOrder();
					break;
				case 8:
					showDataOrder();
					break;
				case 9:
					istrue = false;
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					return;
				}

			} catch (Exception e) {
				ExceptionHelper2.handleException(e);
			}

		}
	}

	// 상품 정보 생성 메소드
	private static void createCart() {
		System.out.println("상품 생성");
		System.out.println("상품 이름 입력: ");
		String productName = scan.nextLine();
		System.out.println("상품 가격 입력: ");
		String productPrice = scan.nextLine();
		System.out.println("상품 재고 입력: ");
		String productStock = scan.nextLine();
		System.out.println("상품 입력: ");
		String product = scan.nextLine();
		System.out.println("상품 정보 입력:");
		String productInformation = scan.nextLine();

		Cart cart = new Cart(productName, productPrice, productStock, product, productInformation);
		cartList.add(cart);

		System.out.println("상품의 정보가 생성되었습니다.");
	}

	// 상품 삭제 메소드
	private static void deleteCart() {
		System.out.println("삭제할 상품의 이름 입력: ");
		String productName = scan.nextLine();
		boolean deleteC = false;
		for (Cart carts : cartList) {
			if (carts.getProductName().equals(productName)) {
				cartList.remove(carts);
				deleteC = true;
				System.out.println("상품의 정보가 삭제되었습니다.");
				break;
			}
		}
		if (!deleteC) {
			System.out.println("해당 상품의 이름이 없습니다.");
		}
	}

	// 상품 정보 수정 메소드
	private static void modifyCart() {
		System.out.println("수정할 상품의 이름 입력");
		String productName = scan.nextLine();
		boolean mdc = false;
		Cart modifyes = null;
		for (Cart modifys : cartList) {
			if (modifys.getProductName().equals(productName)) {
				modifyes = modifys;
				mdc = true;
				System.out.println("상품의 정보가 수정되었습니다.");
				break;
			}
		}
		if (!mdc) {
			System.out.println("해당 상품의 이름이 없습니다.");
		}
	}

	// 상품 정보 출력 메소드
	private static void showDataCart() {
		System.out.println("출력할 상품의 이름 입력");
		String productName = scan.nextLine();
		boolean sdc = false;
		for (Cart carts : cartList) {
			if (carts.getProductName().equals(productName)) {
				System.out.println(carts.getProductName());
				System.out.println(carts.getProductPrice());
				System.out.println(carts.getProductStock());
				System.out.println(carts.getProduct());
				System.out.println(carts.getProductInformaiton());
				System.out.println("해당 상품의 정보가 출력되었습니다.");
				sdc = true;
				break;
			}
		}
		if (!sdc) {
			System.out.println("해당 상품의 이름이 없습니다.");
		}
	}

	private static void createOrder() {
		System.out.println("결제 정보 생성");
		System.out.println("이름 입력: ");
		String productName = scan.nextLine();
		System.out.println("구매할 상품 가격 입력: ");
		String productPrice = scan.nextLine();
		System.out.println("구매할 상품 수량 입력: ");
		String productStock = scan.nextLine();
		System.out.println("상품 결제 상황 입력: ");
		System.out.println("Ex: 결제 완료");
		String orderedPirce = scan.nextLine();
		System.out.println("상품 결제 금액 입력: ");
		String paymentAmount = scan.nextLine();
		System.out.println("상품 결제 용도 입력: ");
		System.out.println("EX:무통장입금, 카드");
		String paymentPurpose = scan.nextLine();
		System.out.println("상품 환불 원인 입력: ");
		System.out.println("EX:상품상태 불량");
		String refundProduct = scan.nextLine();

		Order order = new Order(productName, productPrice, productStock, orderedPirce, paymentAmount, paymentPurpose,
				refundProduct);
		orderList.add(order);
		System.out.println("결제 정보가 생성되었습니다.");
	}

	private static void deleteOrder() {
		System.out.println("삭제할 이름 입력: ");
		String productName = scan.nextLine();

		boolean deleteO = false;
		for (Order orders : orderList) {
			if (orders.getProductName().equals(productName)) {
				orderList.remove(orders);
				deleteO = true;
				System.out.println("결제 정보가 삭제되었습니다.");
				break;
			}
		}
		if (!deleteO) {
			System.out.println("해당 이름이 없습니다.");
		}
	}

	private static void modifyOrder() {
		System.out.println("수정할 결제정보 이름 입력: ");
		String productName = scan.nextLine();

		boolean mdO = false;
		Order modifys = null;
		for (Order orders : orderList) {
			if (orders.getProductName().equals(productName)) {
				orders = modifys;
				mdO = true;
				break;
			}
		}
		if (!mdO) {
			System.out.println("해당 결제정보 이름이 없습니다.");
		}
	}

	private static void showDataOrder() {
		System.out.println("출력할 결제정보 이름 입력: ");
		String productName = scan.nextLine();

		boolean sdO = false;

		for (Order orders : orderList) {
			if (orders.getProductName().equals(productName)) {
				System.out.println(orders.getProductName());
				System.out.println(orders.getProductPrice());
				System.out.println(orders.getProductStock());
				System.out.println(orders.getOrderedPrice());
				System.out.println(orders.getPaymentAmount());
				System.out.println(orders.getPaymentPurpose());
				System.out.println(orders.getRefundProduct());
				sdO = true;
				break;
			}
		}
		if (!sdO) {
			System.out.println("해당 결제정보 이름이 없습니다.");
		}

	}

}
