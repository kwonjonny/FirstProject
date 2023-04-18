import java.util.Scanner;

// Main 클래스 정의 
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberController memberController = MemberController.getInstance();

		// 선택지 정의
		while (true) {
			System.out.println("선택하세요 1~4");
			System.out.println("create member");
			System.out.println("read member");
			System.out.println("update member");
			System.out.println("delete member");

			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}

	}

}
