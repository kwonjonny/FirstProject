package View;

import java.util.Scanner;
import Controller.UserController;

public class UserConsoleView {
	private UserController userController;

	public UserConsoleView(UserController userController) {
		this.userController = userController;
	}

	
	public void start() {
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("===== 회원 관리 프로그램 =====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 정보 조회");
			System.out.println("3. 회원 정보 삭제");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 종료");
			System.out.print("메뉴를 선택하세요: ");
			int menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {
			case 1:
				userController.createUserConsole();
				break;
			case 2:
				userController.readUserConsole();
				break;
			case 3:
				userController.deleteUserConsole();
			case 4:
				userController.updateUserConsole();
			case 5:
				System.out.println("프로그램을 종료합니다.");
				isRunning = false;
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
			System.out.println();
		}
		scan.close();
	}
}
