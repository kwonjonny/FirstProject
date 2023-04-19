package view;

import java.sql.SQLException;
import java.util.Scanner;
import model.Employees;
import model.Jobs;
import service.EmployeeJobService;

public class ServcieConsoleView {

	private static EmployeeJobService employeeJobService;

	public ServcieConsoleView(EmployeeJobService employeeJobService) {
		this.employeeJobService = employeeJobService;
	}

	// Main 에서 사용자가 사용하기 위한 메소드 정의
	public void EmployeeJobStart() {
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("=== 사원과 직업 정보 시스템 ===");
			System.out.println("1. 사원과 직업 정보 생성");
			System.out.println("2. 사원과 직업 정보 출력");
			System.out.println("3. 사원과 직업 정보 수정");
			System.out.println("4. 사원과 직업 정보 삭제");
			System.out.println("5. 종료");
			System.out.println("메뉴 선택: ");
			int menu = scan.nextInt();
			scan.nextLine().trim();

			switch (menu) {
			case 1:
				System.out.println("직업 정보 입력");
				System.out.println("직업 ID: ");
				String jobId = scan.nextLine();
				System.out.println("직업 제목: ");
				String jobTitle = scan.nextLine();
				System.out.println("직업 설명: ");
				String jobDescription = scan.nextLine();
				System.out.println("월급: ");
				int salary = scan.nextInt();
				Jobs job = new Jobs(jobId, jobTitle, jobDescription, salary);

				System.out.println("사원 정보 입력");
				System.out.println("사원 이름: ");
				String name = scan.next();
				System.out.println("이메일: ");
				String email = scan.next();
				System.out.println("전화번호: ");
				String phoneNumber = scan.next();
				System.out.println("입사일 (yyyy-mm-dd): ");
				String hireDate = scan.next();
				System.out.println("직업 ID: ");
				String jobIdForEmployee = scan.next();
				Employees employee = new Employees(name, email, phoneNumber, hireDate, jobIdForEmployee);

				try {
					employeeJobService.createJobsAndEmployees(job, employee);
				} catch (SQLException e) {
					System.out.println("사원과 직업 정보 생성 실패: " + e.getMessage());
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("삭제할 직업 ID 입력: ");
				String deleteJobId = scan.next();
				System.out.println("삭제할 사원 이름 입력: ");
				String deleteEmployeeName = scan.next();

				try {
					employeeJobService.deleteJobsAndEmployees(deleteJobId, deleteEmployeeName);
					System.out.println("사원과 직업 정보 삭제 성공");
				} catch (SQLException e) {
					System.out.println("사원과 직업 정보 삭제 실패: " + e.getMessage());
				}
				break;
			case 5:
				System.out.println("=== 사원과 직업 정보 시스템 종료 ===");
				isRunning = false;
				break;
			default:
				System.out.println("=== 잘못 입력하셨습니다. ===");
				break;
			}
		}
	}
}