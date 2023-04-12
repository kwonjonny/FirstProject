import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 배송 Controller 
public class DeliveryController implements DeliveryFast {

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
