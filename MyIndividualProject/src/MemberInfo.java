import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	// 인스턴스 변수 정의
	private String name;
	private String id;
	private String password;
	private String email;
	private String phoneNumber;

	// 생성자 정의
	public MemberInfo(String name, String id, String password, String email, String phoneNumber) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// Getter Setter 정의
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

interface MemberImpl {
	// 멤버 생성
	void createMember(String name, String id, String password, String email, String phoneNumber);

	// 멤버 삭제
	void deleteMember(String name, String id, String password);

	// 멤버 수정
	void modifyMember(String name, String id, String password);

	// 멤버 출력
	void showDataMember(String name, String id, String password);

	// viewSingleMember
	void viewSingleMember(String name, String id, String password);
}

class MemberRepository {
	// ArrayList 정의
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

	public ArrayList<MemberInfo> getMemberList() {
		return memberInfoList;
	}

	public MemberInfo getMember(String id, String password, String name) {
		for (MemberInfo member : memberInfoList) {
			if (member.getId().equals(id) && member.getPassword().equals(password) && member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	public void showDataMember() {
		System.out.println("=== 회원 목록 ===");
		for (MemberInfo member : memberInfoList) {
			System.out.println("이름: " + member.getName() + ", 아이디: " + member.getId() + ", 이메일: " + member.getEmail()
					+ ", 전화번호: " + member.getPhoneNumber());
		}
	}
}

class MemberController implements MemberImpl {

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
	public void deleteMember(String name, String id, String password) {
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
		MemberInfo member = memberRepository.getMember(id, password, name);
		if (member != null) {
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

class PaymentInfo {
	// 인스턴스 변수 정의
	private String paymentAmount;

	// 생성자 정의
	public PaymentInfo(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	// Getter Setter 정의
	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}

interface PaymentImpl {

	// showPayment 금융 정보 출력
	void showPayment(String name, String id, String password);

	// refund 환불
	void refund(String name, String id, String password);

	// addPayment 계좌 추가
	void addPayment(String name, String id, String password);

	// editPayment 계좌 추가 ??
	void editPayment(String name, String id, String password);
	
	
}

class PaymentRepository {
	// ArrayList 정의
	private ArrayList<PaymentInfo> paymentInfoList;

	public PaymentRepository() {
		paymentInfoList = new ArrayList<>();
	}

	public void addPaymentForMember(PaymentInfo payment, MemberInfo member) {
		// 해당 멤버의 PaymentInfo 객체를 추가하는 로직
	}

	public void editPaymentForMember(PaymentInfo payment, MemberInfo member) {
		// 해당 멤버의 PaymentInfo 객체를 수정하는 로직
	}

	public void deletePaymentForMember(PaymentInfo payment, MemberInfo member) {
		// 해당 멤버의 PaymentInfo 객체를 삭제하는 로직
	}

	public ArrayList<PaymentInfo> getPaymentsForMember(MemberInfo member) {
		// 해당 멤버의 PaymentInfo 객체들을 찾아내는 로직
	}

}

class PaymentController implements PaymentImpl {
    private static PaymentController instance;
    private PaymentRepository paymentRepository;
    private MemberRepository memberRepository;

    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
        }
        return instance;
    }

    private PaymentController() {
        paymentRepository = new PaymentRepository();
        memberRepository = new MemberRepository();
    }

    @Override
    public void showPayment(String name, String id, String password) {
        // MemberRepository에서 해당 멤버 정보가 맞는지 확인합니다.
        MemberInfo member = memberRepository.getMember(id, password, name);
        if (member == null) {
            System.out.println("해당 멤버 정보를 찾을 수 없습니다.");
            return;
        }

        // PaymentRepository에서 해당 멤버의 PaymentInfo 객체들의 정보를 출력합니다.
        ArrayList<PaymentInfo> payments = paymentRepository.getPaymentsForMember(member);
        System.out.println("=== " + member.getName() + " 님의 결제 내역 ===");
        for (PaymentInfo payment : payments) {
            System.out.println("결제 금액: " + payment.getPaymentAmount());
        }
    }

    @Override
    public void refund(String name, String id, String password) {
        // 환불 로직 구현
    }

    @Override
    public void addPayment(String name, String id, String password) {
        // 결제 추가 로직 구현
    }

    @Override
    public void editPayment(String name, String id, String password) {
        // 결제 수정 로직 구현
    }

		
	}
}
