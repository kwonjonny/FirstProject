package PaymentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 자바 2주차 
// 내가 설계한 회원정보와 , 결제시스템  
// 목표 -> 회원정보와 결제시스템 로직을 통합하여 메인메소드에서 
// 환불을 할수있게만드는 시스템을 구현해보자 

// 회원 정보 클래스 
public class MemberInfo {

	// 인스턴스 변수 정의
	private String name; // 이름
	private String email; // 이메일
	private String phoneNumber; // 번호
	private int paymentAmount; // 결제 금액
	private boolean isRefundRequested; // 환불요청
	private String id; // 아이디
	private String password; // 비밀번호

	// 생성자 정의
	public MemberInfo(String name, String id, String password, String email, String phoneNumber, int paymentAmount,
			boolean isRefundRequested) {
		this.name = name;
		this.email = email;
		this.paymentAmount = paymentAmount;
		this.isRefundRequested = isRefundRequested;
		this.id = id;
		this.password = password;
	}

	// Getter Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public boolean getIsRefundRequested() {
		return isRefundRequested;
	}

	public void setIsRefundRequested(boolean isRefundRequested) {
		this.isRefundRequested = isRefundRequested;
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
}

// 결제 정보 클래스 
class PaymentInfo {

	// 인스턴스 변수 정의
	private String paymentMethod; // 결제 방법
	private int payAmount; // 결제 금액
	private String paymentStatus; // 결제 현황
	private MemberInfo memberInfo; // 회원정보 인스턴스

	// 생성자 정의
	public PaymentInfo(MemberInfo memberInfo, String paymentMethod, int payAmount, String paymentStatus) {
		this.paymentMethod = paymentMethod;
		this.payAmount = payAmount;
		this.paymentStatus = paymentStatus;
	}

	// MemberInfo Getter Setter
	public MemberInfo getMeberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}

	// PaymentInfo Getter Setter
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}

// 결제 인터페이스 
interface Payment {

	private static void showPayment() {
	}

	private static void refund(String name, String id, String password) {
	}

}

//class payment2 implements Payment {
//	private List<PaymentInfo> payments = new ArrayList<>();
//	
//}

interface MemberCurd {

	// 회원 정보 생성
	private static void createMember() {
	}

	// 회원 정보 삭제
	private static void deleteMeber() {
	}

	// 회원 정보 수정
	private static void modifyMember() {
	}

	// 회원 정보 출력
	private static void showDataMember() {
	}

}

class ExceptionHelper3 {
	public static void helper(Exception e) {
		System.out.println("확인되지 않은 입력입니다 관리자에게 문의하세요" + e.getMessage());
	}
}

class Main3 {

	private static ArrayList<MemberInfo> memberInfoList = new ArrayList<>();
	private static ArrayList<PaymentInfo> paymentInfoList = new ArrayList<>();

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("===환불 시스템을 시작합니다===");

		boolean running = true;
		while (true) {
			try {
				System.out.println("=======================");
				System.out.println("1. 회원 가입");
				System.out.println("2. 회원 정보 삭제");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 정보 출력");
				System.out.println("5. 결제 시스템");
				System.out.println("6. 환불 시스템");
				System.out.println("7. 종료");
				System.out.println("원하는 작업 선택(1~7)");
				int choice = scan.nextInt();

				switch (choice) {
				case 1:
					createMember();
					break;
				case 2:
					deleteMeber();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					showDataMember();
					break;
				case 5:

					showPayment();
					break;
				case 6:
					refund();
					break;
				case 7:
					running = false;
					return;
				default:
					System.out.println("시스템 종료");
				}
			} catch (Exception e) {
				ExceptionHelper3.helper(e);
			}
		}
	}

	// 회원 정보 생성
	private static void createMember() {
		
		MemberInfo memberInfo1 = new MemberInfo("name", "id", "password", "email", "phoneNumber", 132,
				true);
		memberInfoList.add(memberInfo1);
		
		
		System.out.println("회원 이름 입력: ");
		String name = scan.nextLine();
		System.out.println("회원 아이디 입력: ");
		String id = scan.nextLine();
		System.out.println("회원 비밀번호 입력: ");
		String password = scan.nextLine();
		System.out.println("회원 이메일 입력: ");
		String email = scan.nextLine();
		System.out.println("회원 번호 입력: ");
		String phoneNumber = scan.nextLine();
		System.out.println("회원 결제 금액 입력: ");
		int paymentAmount = scan.nextInt();
		System.out.println("환불 여부 체크 F & N");
		boolean isRefundReuqested = scan.nextBoolean();
		MemberInfo memberInfo = new MemberInfo(name, id, password, email, phoneNumber, paymentAmount,
				isRefundReuqested);
		
		memberInfoList.add(memberInfo);
		System.out.println("회원 정보 생성 완료.");
	}

	// 회원 정보 삭제
	private static void deleteMeber() {
		System.out.println("회원 탈퇴 입니다. 회원이름,아이디,비밀번호 입력");
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("아이디: ");
		String id = scan.nextLine();
		System.out.println("비밀번호");
		String password = scan.nextLine();

		for (MemberInfo memberinfo : memberInfoList) {
			if (memberinfo.getName().equals(name) && memberinfo.getId().equals(id)
					&& memberinfo.getPassword().equals(password)) {
				memberInfoList.remove(memberinfo);
				System.out.println("회원 정보가 삭제되었습니다.");
				break;
			}
		}
	}

	// 회원 정보 수정
	private static void modifyMember() {
		System.out.println("회원 정보 수정입니다. 회원이름,아이디,비밀번호 입력");
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("아이디: ");
		String id = scan.nextLine();
		System.out.println("비밀번호: ");
		String password = scan.nextLine();

		MemberInfo modifyM = null;
		for (MemberInfo memberinfo : memberInfoList) {
			if (memberinfo.getName().equals(name) && memberinfo.getId().equals(id)
					&& memberinfo.getPassword().equals(password)) {
				System.out.println("새 회원정보 입력: ");
				System.out.println("이름: ");
				String newName = scan.nextLine();
				System.out.println("아이디: ");
				String newId = scan.nextLine();
				System.out.println("비밀번호: ");
				String newPassword = scan.nextLine();
				System.out.println("이메일: ");
				String newEmail = scan.nextLine();
				System.out.println("전화번호: ");
				String newPhoneNumber = scan.nextLine();
				System.out.println("회원결제액: ");
				int newPaymentAmount = scan.nextInt();
				System.out.println("회원 환불 여부 체크 F&N : ");
				boolean newIsRefundRequested = scan.nextBoolean();

				modifyM = new MemberInfo(newName, newId, newPassword, newEmail, newPhoneNumber, newPaymentAmount,
						newIsRefundRequested);

				memberinfo.setName(modifyM.getName());
				memberinfo.setId(modifyM.getId());
				memberinfo.setPassword(modifyM.getPassword());
				memberinfo.setEmail(modifyM.getEmail());
				memberinfo.setPhoneNumber(modifyM.getPhoneNumber());
				memberinfo.setPaymentAmount(modifyM.getPaymentAmount());
				memberinfo.setIsRefundRequested(modifyM.getIsRefundRequested());
				System.out.println("회원 정보가 수정되었습니다.");
				break;
			}
		}
		// 수정된 회원 정보 출력
		System.out.println("수정된 회원 정보입니다.");
		System.out.println("이름: " + modifyM.getName());
		System.out.println("아이디: " + modifyM.getId());
		System.out.println("비밀번호: " + modifyM.getPassword());
		System.out.println("이메일: " + modifyM.getEmail());
		System.out.println("전화번호: " + modifyM.getPhoneNumber());
		System.out.println("회원결제액: " + modifyM.getPaymentAmount());
		System.out.println("회원 환불 여부: " + modifyM.getIsRefundRequested());

		// 회원 정보 출력
		showDataMember();
	}

	// 회원 정보 출력
	private static void showDataMember() {
		System.out.println("회원 정보 출력입니다. 회원이름,아이디,비밀번호 입력");
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("아이디: ");
		String id = scan.nextLine();
		System.out.println("비밀번호: ");
		String password = scan.nextLine();
		for (MemberInfo memberinfo : memberInfoList) {
			if (memberinfo.getName().equals(name) && memberinfo.getId().equals(id)
					&& memberinfo.getPassword().equals(password)) {
				System.out.println(memberinfo.getName());
				System.out.println(memberinfo.getId());
				System.out.println(memberinfo.getPassword());
				System.out.println(memberinfo.getEmail());
				System.out.println(memberinfo.getPaymentAmount());
				System.out.println(memberinfo.getIsRefundRequested());
			}
		}

	}

	// 결제 정보 조회 로직
	private static void showPayment(String name, String id, String password) {
		// 결제 정보를 조회하는 로직 구현
		for (PaymentInfo paymentInfo : paymentInfoList) {
			if (paymentInfo.getMeberInfo().getName().equals(name) && paymentInfo.getMeberInfo().getId().equals(id)
					&& paymentInfo.getMeberInfo().getPassword().equals(password)) {
				System.out.println("Payment Method: " + paymentInfo.getPaymentMethod());
				System.out.println("Payment Amount: " + paymentInfo.getPayAmount());
				System.out.println("Payment Status: " + paymentInfo.getPaymentStatus());
				System.out.println("Member Name: " + paymentInfo.getMeberInfo().getName());
				System.out.println("Member Email: " + paymentInfo.getMeberInfo().getEmail());
				System.out.println("Member Phone Number: " + paymentInfo.getMeberInfo().getPhoneNumber());
				break;
			}
		}
	}

	// 환불 처리 로직
	private static void refund(String name, String id, String password) {

		// 환불 정보를 처리하는 로직 구현
		for (PaymentInfo paymentInfo : paymentInfoList) {
			if (paymentInfo.getMeberInfo().getName().equals(name) && paymentInfo.getMeberInfo().getId().equals(id)
					&& paymentInfo.getMeberInfo().getPassword().equals(password)) {
				paymentInfo.getMeberInfo().setIsRefundRequested(true);
				System.out.println(" 결제 id에 대한 활불 요청 " + paymentInfo.getMeberInfo().getId() + " by " + name);
				break;
			}
		}
	}
}
