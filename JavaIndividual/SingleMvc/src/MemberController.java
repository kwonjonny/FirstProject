import java.util.List;
import java.util.Scanner;

public class MemberController {
	
	private Scanner scanner;
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.scanner = new Scanner(System.in);
		this.memberService = memberService;
	}

	public void joinMember() {
		System.out.println("===== 회원 가입 =====");
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.print("아이디를 입력하세요: ");
		String id = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		System.out.print("나이를 입력하세요: ");
		int age = Integer.parseInt(scanner.nextLine());
		Member newMember = new Member(name, id, password);
		memberService.join(newMember);
		System.out.println("회원가입이 완료되었습니다.");
	}

	public void findMember() {
		System.out.println("===== 회원 조회 =====");
		System.out.print("조회할 회원의 id를 입력하세요: ");
		String id = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		Member member = memberService.findMember(id, password);
		if (member != null) {
			System.out.println("조회된 회원 정보: " + member);
		} else {
			System.out.println("해당 id의 회원을 찾을 수 없습니다.");
		}
	}

	public void updateMember() {
		System.out.println("===== 회원 수정 =====");
		System.out.print("수정할 회원의 id를 입력하세요: ");
		String id = scanner.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String password = scanner.nextLine();
		Member member = memberService.findMember(id, password);
		if (member != null) {
			System.out.print("새로운 이름을 입력하세요: ");
			String newName = scanner.nextLine();
			System.out.print("새로운 비밀번호를 입력하세요: ");
			String newPassword = scanner.nextLine();
			System.out.print("새로운 나이를 입력하세요: ");
			int newAge = Integer.parseInt(scanner.nextLine());
			Member newMember = new Member(newName, id, newPassword);
			memberService.updateMember(newMember);
			System.out.println("회원 정보가 수정되었습니다.");
		} else {
			System.out.println("해당 id의 회원을 찾을 수 없습니다.");
		}
	}

	public void removeMember() {
		System.out.println("===== 회원 삭제 =====");
		System.out.print("삭제할 회원의 id를 입력하세요: ");
		String id = scanner.nextLine();
		memberService.removeMember(id);
		System.out.println("회원 정보가 삭제되었습니다.");
	}

	public void printAllMembers() {
		System.out.println("===== 전체 회원 조회 =====");
		List<Member> members = memberService.getMemberList();
		if (members.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		} else {
			for (Member member : members) {
				System.out.println(member);
			}
		}
	}
}
