package controller;

import service.EmployeeJobService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import domain.Employees;
import domain.JobHistory;
import domain.Jobs;
import dao.JobHistoryDAO;

public class ServiceController {

	private static EmployeeJobService employeeJobService;

	public ServiceController(EmployeeJobService employeeJobService) {
		this.employeeJobService = employeeJobService;
	}

	Scanner scan = new Scanner(System.in);

	public void createEmployeeJob() {
		System.out.println("직업 정보-사원 정보-고용일,퇴사일 입력:");
		System.out.println("직업 정보 입력");
		System.out.println("Job ID입력: ");
		String jobId = scan.nextLine();
		System.out.println("직업 입력: ");
		String jobTitle = scan.nextLine();
		System.out.println("직업 직무: ");
		String jobDescription = scan.nextLine();
		System.out.println("월급: ");
		int salary = scan.nextInt();
		Jobs job = new Jobs(jobId, jobTitle, jobDescription, salary);

		System.out.println("사원 정보 입력");
		System.out.println("직업 ID: ");
		String jobIdForEmployee = scan.next();
		
		System.out.println("사원 이름: ");
		String name = scan.next();
		
		System.out.println("이메일: ");
		String email = scan.next();
		
		System.out.println("전화번호: ");
		String phoneNumber = scan.next();
		
		System.out.println("입사일 (yyyy-mm-dd): ");
		String hireDate = scan.next();
		
		Employees employee = new Employees(jobIdForEmployee, name, email, phoneNumber, hireDate);

		System.out.println("Job History 입력");
		System.out.println("직업 id: ");
		String jobIdHistroy = scan.next();
		
		System.out.println("입사일 (yyyy-mm-dd): ");
		String startDateStr = scan.next();
		LocalDate startDate = LocalDate.parse(startDateStr);
		
		System.out.println("퇴사일 (YYYY-MM-DD): ");
		String endDateStr = scan.next();
		LocalDate endDate = LocalDate.parse(endDateStr);
		
		System.out.println("직업 ID 입력: ");
		String jobIdHistory = scan.next();

		JobHistory jobCreate = new JobHistory(jobIdHistroy, startDate, endDate, jobIdHistory);

		try {
			employeeJobService.createJobsAndEmployees(job, employee, jobCreate);
			System.out.println("사원과 직업 정보 job history 생성 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("사원과 직업 정보 job history 생성 실패: " + e.getMessage());
		}
	}

	public void readEmployeeJob() {
		System.out.println("직업 정보-사원 정보-고용일,퇴사일 출력");
		System.out.println("기존 이름입력: ");
		String nameRead = scan.next();
		
		System.out.println("기존 Job ID입력: ");
		String jobIdRead = scan.next();
		
		System.out.println("기존 Employee ID 입력: ");
		String employeeId = scan.next();

		try {
			employeeJobService.readJobsAndEmployees(nameRead, jobIdRead, employeeId);
			System.out.println("사원과 직업 정보 job history read 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("사원과 직업 정보 job history read 실패" + e.getMessage());
		}
	}

	public void updateEmployeeJob() {
		System.out.println("기존 employee 이름 입력:");
		String oldEmployeeName = scan.next();

		System.out.println("기존 Jobs_id 입력: ");
		String oldJobsId = scan.next();

		System.out.println("기존 employee_id 입력: ");
		String oldEmployeeId = scan.next();

		System.out.println("=== 새로운 사원 정보 입력 ===");
		System.out.println("새로운 직업 ID: ");
		String newJobIdForEmployee = scan.nextLine().trim();

		System.out.println("새로운 사원 이름: ");
		String newName = scan.nextLine().trim();

		System.out.println("새로운 이메일: ");
		String newEmail = scan.nextLine().trim();

		System.out.println("새로운 전화번호: ");
		String newPhoneNumber = scan.nextLine().trim();

		System.out.println("새로운 입사일 (yyyy-mm-dd): ");
		String newHireDate = scan.nextLine().trim();
		
		Employees newEmployees = new Employees(newJobIdForEmployee, newName, newEmail, newPhoneNumber, newHireDate);
		
		System.out.println("=== 수정 사항 입력 ===");
		System.out.println("=== 새로운 Job 정보 입력 ===");

		System.out.println("새로운 직업 ID: ");
		String newJobId = scan.next();
		
		System.out.println("새로운 직업 제목: ");
		String newJobTitle = scan.next();
		
		System.out.println("새로운 직업 설명: ");
		String newJobDescription = scan.next();
		
		System.out.println("새로운 월급: ");
		int newSalary = scan.nextInt();
		scan.nextLine();

		Jobs newJobs = new Jobs(newJobId, newJobTitle, newJobDescription, newSalary);
		
		System.out.println("새로운 사원 ID 입력: ");
		String newId = scan.nextLine();
		
		System.out.println("새로운 입사일 입력(YYYY-MM-DD): ");
		String newStartDateStr = scan.next();
		LocalDate newStartDate = LocalDate.parse(newStartDateStr);
		
		System.out.println("새로운 퇴사일 입력(YYYY-MM-DD): ");
		String newEndDateStr = scan.next();
		LocalDate newEndDate = LocalDate.parse(newEndDateStr);
		scan.nextLine(); // 버퍼 비우기
		
		System.out.println("새로운 Job ID 입력: ");
		String newidJob = scan.nextLine();
		
		JobHistory newJobHistory = new JobHistory(newId, newStartDate, newEndDate, newidJob);
		
		try {
	        employeeJobService.updateJobsAndEmployees(oldEmployeeName, newEmployees, oldJobsId, newJobs, oldEmployeeId, newJobHistory);
	        System.out.println("사원과 직업 정보 job history update 완료");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("사원과 직업 정보 job history update 실패" + e.getMessage());
	    }
		
	}

	public void deleteEmployeeJob() {
		System.out.println("삭제할 직원 ID 입력: ");
		String deleteEmployeId = scan.next();

		System.out.println("삭제할 직업 ID 입력: ");
		String deleteJobId = scan.next();
		
		System.out.println("삭제할 사원 이름 입력: ");
		String deleteEmployeeName = scan.next();
		
		
		try {
			employeeJobService.deleteJobsAndEmployees(deleteEmployeId, deleteJobId , deleteEmployeeName);
			System.out.println("사원과 직업 정보 job history delete 완료");
		} catch (SQLException e) {
			System.out.println("사원과 직업 정보 job history delete 실패" + e.getMessage());
		}
	}

	public void EmployeeJobStart() {
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("=== 사원과 직업 정보 시스템 ===");
			System.out.println("1. 사원과 직업 정보 생성");
			System.out.println("2. 사원과 직업 정보 출력");
			System.out.println("3. 사원과 직업 정보 수정");
			System.out.println("4. 사원과 직업 정보 삭제");
			int menu = scan.nextInt();
			scan.nextLine().trim();

			switch (menu) {
			case 1:
				createEmployeeJob();
				break;
			case 2:
				readEmployeeJob();
				break;
			case 3:
				updateEmployeeJob();
				break;
			case 4:
				deleteEmployeeJob();
				break;
			case 5:
				isRunning = false;
				break;
			default:
				break;
			}
		}
	}
}
