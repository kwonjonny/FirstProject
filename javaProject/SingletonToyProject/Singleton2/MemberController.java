import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 회원 Controller 
public class MemberController implements MemberCrud {

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