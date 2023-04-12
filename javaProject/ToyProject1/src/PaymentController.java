import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Payment Controller 
public class PaymentController implements PaymentCrud, PaymentNoMemberCrud {

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