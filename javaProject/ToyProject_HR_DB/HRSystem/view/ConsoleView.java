package view;

import java.util.Scanner;

import controller.EmployeesController;
import controller.JobsController;

public class ConsoleView {

	private EmployeesController employeesController;
	private JobsController jobsController;

	public ConsoleView(EmployeesController employeesController, JobsController jobsController) {
		this.employeesController = employeesController;
		this.jobsController = jobsController;
	}

	// Main 에서 사용자가 사용하기 위한 메소드 정의
	public void start() {
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("=== 사원 정보 개별 입력 ===");
			System.out.println("1. 사원 정보 입력");
			System.out.println("2. 사원 정보 출력");
			System.out.println("3. 사원 정보 수정");
			System.out.println("4. 사원 정보 삭제");
			System.out.println("=== 직업 정보 개별 입력 ===");
			System.out.println("5. 직업 정보 입력");
			System.out.println("6. 직업 정보 출력");
			System.out.println("7. 직업 정보 수정");
			System.out.println("8. 직업 정보 삭제");
			System.out.println("9. 종료");
			System.out.println("메뉴 선택: ");
			int menu = scan.nextInt();
			scan.nextLine().trim();

			switch (menu) {
			case 1:
				employeesController.createEmployeeConsole();
				break;
			case 2:
				employeesController.readEmployeeConsole();
				break;
			case 3:
				employeesController.updateEmployeeConsole();
				break;
			case 4:
				employeesController.deleteEmployeeConsole();
				break;
			case 5:
				jobsController.createJobsConsole();
				break;
			case 6:
				jobsController.readJobsConsole();
				break;
			case 7:
				jobsController.updateJobsConsole();
				break;
			case 8:
				jobsController.deleteJobsConsole();
				break;
			case 9:
				System.out.println("=== 사원 정보 관리 프로그램 종료 ===");
				isRunning = false;
				break;
			default:
				System.out.println("=== 잘못 입력하셨습니다. ===");
				break;
			}
			System.out.println();
		}
		scan.close();
	}
}
