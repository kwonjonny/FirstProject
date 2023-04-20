package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import domain.Employees;
import domain.JobHistory;
import domain.Jobs;
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
				
				System.out.println("job history 입력");
				System.out.println("직업 id: ");
				String jobIdHistroy = scan.next();
				System.out.println("입사일 (yyyy-mm-dd): ");
				String startDateStr = scan.next();
				LocalDate startDate = LocalDate.parse(startDateStr);
				System.out.println("퇴사일 입력(YYYY-MM-DD): ");
				String endDateStr = scan.next();
				LocalDate endDate = LocalDate.parse(endDateStr);
				System.out.println("직업 ID 입력: ");
				String jobIdHistory = scan.next();

				JobHistory jobCreate = new JobHistory(jobIdHistroy, startDate, endDate, jobIdHistory);

				try {
					employeeJobService.createJobsAndEmployees(job, employee,jobCreate);
					System.out.println("사원과 직업 정보 job history 생성 완료");
				} catch (SQLException e) {
					System.out.println("사원과 직업 정보 job history 생성 실패: " + e.getMessage());
				}
				break;
			case 2:
				System.out.println("직업 ID입력: ");
				String jobIdRead = scan.nextLine();
				System.out.println("사원 이름입력: ");
				String nameRead = scan.nextLine();
				System.out.println("직원 ID 입력: ");
				String employeeId = scan.next();
				System.out.println("직업 ID 입력: ");
				String IdJobRead = scan.next();

				try {
					employeeJobService.readJobsAndEmployees(jobIdRead, nameRead, employeeId, IdJobRead);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("직업 ID입력");
				String jobIdUpdate = scan.nextLine();
				System.out.println("사원 이름입력: ");
				String nameUpdate = scan.nextLine();

				System.out.println("새로운 직업 정보 입력");
				System.out.println("새로운 직업 ID: ");
				String newJobId = scan.nextLine();
				System.out.println("새로운 직업 제목: ");
				String newJobTitle = scan.nextLine();
				System.out.println("새로운 직업 설명: ");
				String newJobDescription = scan.nextLine();
				System.out.println("새로운 월급: ");
				int newSalary = scan.nextInt();
				scan.nextLine();

				Jobs newJobs = new Jobs(newJobId, newJobTitle, newJobDescription, newSalary);

				System.out.println("새로운 사원 정보 입력");
				System.out.println("새로운 사원 이름: ");
				String newName = scan.nextLine();
				System.out.println("새로운 이메일: ");
				String newEmail = scan.nextLine();
				System.out.println("새로운 전화번호: ");
				String newPhoneNumber = scan.nextLine();
				System.out.println("새로운 입사일 (yyyy-mm-dd): ");
				String newHireDate = scan.nextLine();
				System.out.println("새로운 직업 ID: ");
				String newJobIdForEmployee = scan.nextLine();

				Employees newEmployees = new Employees(newName, newEmail, newPhoneNumber, newHireDate,
						newJobIdForEmployee);
				
				System.out.println("수정할 직원id 입력: ");
				String newEmployeeId = scan.nextLine();
				System.out.println("수정할 입사일 입력(YYYY-MM-DD): ");
				String newStartDateStr = scan.next();
				LocalDate newStartDate = LocalDate.parse(newStartDateStr);
				System.out.println("수정할 퇴사일 입력(YYYY-MM-DD): ");
				String newEndDateStr = scan.next();
				LocalDate newEndDate = LocalDate.parse(newEndDateStr);
				System.out.println("수정할 직업id 입력: ");
				String newJobid = scan.nextLine();

				JobHistory newJobHistory = new JobHistory(newEmployeeId, newEndDate, newEndDate, newJobid);

				try {
					employeeJobService.updateJobsAndEmployees(jobIdUpdate, newJobs, nameUpdate, newEmployees, newJobid, newJobHistory);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("삭제할 직업 ID 입력: ");
				String deleteJobId = scan.next();
				System.out.println("삭제할 사원 이름 입력: ");
				String deleteEmployeeName = scan.next();
				System.out.println("삭제할 직원 ID 입력: ");
				String deleteEmployeId = scan.nextLine();
				System.out.println("삭제할 직업 ID 입력: ");
				String deleteIdJob = scan.nextLine();

				try {
					employeeJobService.deleteJobsAndEmployees(deleteJobId, deleteEmployeeName,deleteEmployeId);
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