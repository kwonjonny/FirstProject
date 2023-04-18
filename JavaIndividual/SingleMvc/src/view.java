
import java.util.Scanner;

public class view {
	private static Scanner scanner = new Scanner(System.in);
	private static MemberController memberController = new MemberController(
			new MemberServiceImpl(MemberRepositoryImpl.getInstance()));

	public static void main(String[] args) {
		boolean isStop = false;
		while (!isStop) {
			System.out.println("=======================");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 조회");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 전체 회원 조회");
			System.out.println("6. 종료");
			System.out.println("=======================");
			System.out.print("번호를 입력하세요: ");

			int menuNum = scanner.nextInt();
			scanner.nextLine();

			switch (menuNum) {
			case 1:
				memberController.joinMember();
				break;
			case 2:
				memberController.findMember();
				break;
			case 3:
				memberController.updateMember();
				break;
			case 4:
				memberController.removeMember();
				break;
			case 5:
				memberController.printAllMembers();
				break;
			case 6:
				isStop = true;
				break;
			default:
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		}
		scanner.close();
	}
}
