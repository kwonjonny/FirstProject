import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	// 필드 추가
	private String name;
	private String id;
	private String password;
	private String email;
	private String phoneNumber;

	public MemberInfo(String name, String id, String password, String email, String phoneNumber) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

class PaymentInfo {
	// 필드 추가

	private String paymentAmount;

	public PaymentInfo(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}

interface Member {
	// 메서드 정의
	// 회원 정보 생성
	void createMember(String name, String id, String password, String email, String phoneNumber);

	// 회원 정보 삭제
	void deleteMeber(String name, String id, String password);

	// 회원 정보 수정
	void modifyMember(String name, String id, String password);

	// 회원 정보 출력
	void showDataMember(String name, String id, String password);

	void viewSingleMember(String id, String password, String name);
}

interface Payment {
	// 메서드 정의
	void showPayment(String name, String id, String password);

	void refund(String name, String id, String password);

	void addPayment(PaymentInfo paymentInfo);

	void editPayment(String name, String id, String password);

}

class MemberRepository {
	private ArrayList<MemberInfo> memberInfoList;

	public MemberRepository() {
		memberInfoList = new ArrayList<>();
	}

	public void createMember(MemberInfo member) {
		memberInfoList.add(member);
	}

	public void deleteMember(MemberInfo member) {
		memberInfoList.remove(member);
	}

	public void showDataMember() {
		System.out.println("=== 회원 목록 ===");
		for (MemberInfo member : memberInfoList) {
			System.out.println("이름: " + member.getName() + ", 아이디: " + member.getId() + ", 이메일: " + member.getEmail()
					+ ", 전화번호: " + member.getPhoneNumber());
		}
	}

	public MemberInfo getMember(String id, String password, String name) {
		for (MemberInfo member : memberInfoList) {
			if (member.getId().equals(id) && member.getPassword().equals(password) && member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	public void viewSingleMember(String id, String password, String name) {
		MemberInfo member = getMember(id, password, name);
		if (member != null) {
			System.out.println("=== 회원 정보 ===");
			System.out.println("이름: " + member.getName() + ", 아이디: " + member.getId() + ", 이메일: " + member.getEmail()
					+ ", 전화번호: " + member.getPhoneNumber());
		} else {
			System.out.println("입력한 정보와 일치하는 회원 정보가 없습니다.");
		}
		// 데이터베이스와의 상호작용을 처리하는 메서드
	}

	class PaymentRepository {
		private ArrayList<PaymentInfo> paymentInfoList;

		public PaymentRepository() {
			paymentInfoList = new ArrayList<>();
		}

		public PaymentInfo getPaymentInfo(String paymentAmount) {
			for (PaymentInfo paymentInfo : paymentInfoList) {
				if (paymentInfo.getPaymentAmount().equals(paymentAmount)) {
					return paymentInfo;
				}
			}
			return null;
		}

		public void showPayments() {
			System.out.println("=== 결제 내역 ===");
			for (PaymentInfo paymentInfo : paymentInfoList) {
				System.out.println("결제 금액: " + paymentInfo.getPaymentAmount());
			}
		}

		public void deletePayment(PaymentInfo paymentInfo) {
			paymentInfoList.remove(paymentInfo);
			System.out.println("결제 정보가 삭제되었습니다.");
		}

		public void addPayment(PaymentInfo paymentInfo) {
			paymentInfoList.add(paymentInfo);
			System.out.println("결제 정보가 추가되었습니다.");
		}

		public void editPayment(PaymentInfo paymentInfo, String newAmount) {
			paymentInfo.setPaymentAmount(newAmount);
			System.out.println("결제 정보가 수정되었습니다.");
		}
		// 데이터베이스와의 상호작용을 처리하는 메서드
	}

	class MemberController implements Member {
		private static MemberController instance;
		private MemberRepository memberRepository;

		private MemberController(MemberRepository memberRepository) {
			this.memberRepository = memberRepository;
		}

		public static MemberController getInstance(MemberRepository memberRepository) {
			if (instance == null) {
				instance = new MemberController(memberRepository);
			}
			return instance;
		}

		@Override
		public void createMember(String name, String id, String password, String email, String phoneNumber) {
			MemberInfo newMember = new MemberInfo(name, id, password, email, phoneNumber);
			memberRepository.createMember(newMember);
		}

		@Override
		public void deleteMeber(String name, String id, String password) {
			// 입력받은 이름, 아이디, 패스워드와 일치하는 회원 정보를 MemberRepository에서 찾습니다.
			MemberInfo memberToDelete = memberRepository.getMember(id, password, name);
			if (memberToDelete != null) {
				// MemberRepository에서 회원 정보를 삭제합니다.
				memberRepository.deleteMember(memberToDelete);
				System.out.println("회원 정보가 삭제되었습니다.");
			} else {
				System.out.println("입력한 정보와 일치하는 회원 정보가 없습니다.");
			}
		}

		@Override
		public void modifyMember(String name, String id, String password) {
			// 입력받은 이름, 아이디, 패스워드와 일치하는 회원 정보를 MemberRepository에서 찾습니다.
			MemberInfo memberToModify = memberRepository.getMember(id, password, name);
			if (memberToModify != null) {
				// 회원 정보 수정을 위해 사용자로부터 새로운 회원 정보를 입력받습니다.
				Scanner scanner = new Scanner(System.in);
				System.out.println("새 아이디 입력: ");
				String newId = scanner.nextLine();
				System.out.println("새 비밀번호 입력: ");
				String newPassword = scanner.nextLine();
				System.out.print("새 이름을 입력하세요: ");
				String newName = scanner.nextLine();
				System.out.print("새 이메일을 입력하세요: ");
				String newEmail = scanner.nextLine();
				System.out.print("새 전화번호를 입력하세요: ");
				String newPhoneNumber = scanner.nextLine();

				// 입력받은 회원 정보로 MemberInfo 객체를 생성합니다.
				MemberInfo modifiedMember = new MemberInfo(newName, newId, newPassword, newEmail, newPhoneNumber);
				// MemberRepository에서 기존 회원 정보를 삭제하고, 수정된 회원 정보를 추가합니다.
				memberRepository.deleteMember(memberToModify);
				memberRepository.createMember(modifiedMember);
				System.out.println("회원 정보가 수정되었습니다.");
			} else {
				System.out.println("입력한 정보와 일치하는 회원 정보가 없습니다.");
			}
		}

		@Override
		public void showDataMember(String name, String id, String password) {
			memberRepository.showDataMember();
		}

		@Override
		public void viewSingleMember(String id, String password, String name) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름 확인: ");
			String name1 = scanner.nextLine();
			System.out.print("ID 확인: ");
			String id1 = scanner.nextLine();
			System.out.print("Password 확인: ");
			String password1 = scanner.nextLine();

			// MemberRepository에서 입력받은 이름, 아이디, 비밀번호와 일치하는 회원 정보를 찾습니다.
			MemberInfo member = memberRepository.getMember(id, password, name);

			if (member != null) {
				// 회원 정보를 출력합니다.
				System.out.println("=== 회원 정보 ===");
				System.out.println("이름: " + member.getName());
				System.out.println("아이디: " + member.getId());
				System.out.println("이메일: " + member.getEmail());
				System.out.println("전화번호: " + member.getPhoneNumber());
			} else {
				System.out.println("입력한 정보와 일치하는 회원 정보가 없습니다.");
			}
		}

	}

	class PaymentController implements Payment {

		// 싱글톤 패턴 static으로 선언이유 -> PaymentController내에서만 인스턴스 변수를 받아오게끔함
		private static PaymentController instance;
		private PaymentRepository paymentRepository;
		private MemberRepository memberRepository;

		// 생성자 에서는 MemberRepository 클래스의 인스턴스를 인자로 받아옴
		private PaymentController(PaymentRepository paymentRepository, MemberRepository memberRepository) {
			this.paymentRepository = paymentRepository;
			this.memberRepository = memberRepository;
		}

		// PaymentController 클래스의 싱글톤 인스턴스를 반환하는 getInstance 메소드
		// 이 메서드는 PaymentRepository와 MemberRepository의 인스턴스를 인자로 받아와서 PaymentController
		// 인스턴스를 생성하고 반환
		public static PaymentController getInstance(PaymentRepository paymentRepository,
				MemberRepository memberRepository) {
			if (instance == null) {
				instance = new PaymentController(paymentRepository, memberRepository);
			}
			return instance;
		}

		@Override
		public void showPayment(String name, String id, String password) {
			paymentRepository.showPayments();
		}

		@Override
		public void refund(String name, String id, String password) {
			// 입력받은 결제 금액과 일치하는 결제 정보를 PaymentRepository에서 찾습니다.
			Scanner scanner = new Scanner(System.in);
			System.out.print("취소할 결제 금액을 입력하세요: ");
			String paymentAmount = scanner.nextLine();
			PaymentInfo paymentToRefund = paymentRepository.getPaymentInfo(paymentAmount);
			if (paymentToRefund != null) {
				// PaymentRepository에서 결제 정보를 삭제합니다.
				paymentRepository.deletePayment(paymentToRefund);
			} else {
				System.out.println("입력한 금액과 일치하는 결제 정보가 없습니다.");
			}
		}

		@Override
		public void addPayment(PaymentInfo paymentInfo) {
			paymentRepository.addPayment(paymentInfo);
			System.out.println("지급 정보가 추가되었습니다.");
		}

		@Override
		public void editPayment(String name, String id, String password) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("편집할 지급 금액을 입력하십시오: ");
			String paymentAmount = scanner.nextLine();
			PaymentInfo paymentToEdit = paymentRepository.getPaymentInfo(paymentAmount);
			if (paymentToEdit != null) {
				System.out.print("새 지급 금액을 입력: ");
				String newPaymentAmount = scanner.nextLine();
				PaymentInfo newPaymentInfo = new PaymentInfo(newPaymentAmount);
				paymentRepository.deletePayment(paymentToEdit);
				paymentRepository.addPayment(newPaymentInfo);
				System.out.println("지급 정보가 업데이트되었습니다.");
			} else {
				System.out.println("입력한 금액과 일치하는 지급 정보를 찾을 수 없습니다.");
			}

		}
	}

	class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			MemberRepository memberRepository = new MemberRepository();
			PaymentRepository paymentRepository = new PaymentRepository();

			MemberController memberController = MemberController.getInstance(memberRepository);
			PaymentController paymentController = PaymentController.getInstance(paymentRepository, memberRepository);

			while (true) {
				System.out.println("=====선택======:");
				System.out.println("1. 회원 생성");
				System.out.println("2. 회원 삭제");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 정보 출력");
				System.out.println("5. 결제 관련 정보 출력");
				System.out.println("6. Exit");

				int choice = scanner.nextInt();
				scanner.nextLine(); // 정수 입력 뒤에 줄 바꿈 문자 사용

				switch (choice) {
				case 1:
					System.out.print("멤버 이름 입력: ");
					String name = scanner.nextLine();
					System.out.print("멤버 ID: ");
					String id = scanner.nextLine();
					System.out.print("멤버 password: ");
					String password = scanner.nextLine();
					System.out.print("멤버 Email: ");
					String email = scanner.nextLine();
					System.out.print("멤버 전화번호: ");
					String phoneNumber = scanner.nextLine();

					memberController.createMember(name, id, password, email, phoneNumber);
					break;
				case 2:
					System.out.print("이름 확인: ");
					name = scanner.nextLine();
					System.out.print("ID 확인: ");
					id = scanner.nextLine();
					System.out.print("Password 확인: ");
					password = scanner.nextLine();

					memberController.deleteMeber(name, id, password);
					break;
				case 3:
					System.out.print("이름 확인: ");
					name = scanner.nextLine();
					System.out.print("ID 확인: ");
					id = scanner.nextLine();
					System.out.print("Password 확인: ");
					password = scanner.nextLine();

					memberController.modifyMember(name, id, password);
					break;
				case 4:
					memberController.showDataMember(null, null, null); // 이름, ID 및 암호에 대한 null 값 전달
					break;
				case 5:
					System.out.println("선택해주세요:");
					System.out.println("1. 지급 정보 출력");
					System.out.println("2. 지급 환불");

					int paymentChoice = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character after reading the integer

					switch (paymentChoice) {
					case 1:
						paymentController.showPayment(null, null, null);
						break;
					case 2:
						System.out.print("이름: ");
						String name1 = scanner.nextLine();
						System.out.print("ID: ");
						String id1 = scanner.nextLine();
						System.out.print("Password: ");
						String password1 = scanner.nextLine();

						paymentController.refund(name1, id1, password1);
						break;
					default:
						System.out.println("잘못된 선택입니다. 다시 시도하십시오.");
						break;
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 선택입니다. 다시 시도하십시오.");
					break;
				}
		}
	}
}