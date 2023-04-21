package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dao.JobsDAO;
import dao.JobHistoryDAO;

import dbConnection.DBConnection;

import domain.Employee;
import domain.JobHistory;
import domain.Jobs;

import service.ServiceCreate;
import service.ServiceRead;

public class ServiceControllerCreate {

	private ServiceCreate serviceCreate;
	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceControllerCreate(ServiceCreate serviceCreate,EmployeeDAO employeeDAO, JobsDAO jobsDAO,JobHistoryDAO jobHistoryDAO) {
		this.serviceCreate = serviceCreate;
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}

	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== 새로운 정보를 입력하세요 ===");

		System.out.print("직원 아이디를 입력하세요: ");
		String employeeId = scanner.next();

		System.out.print("직원 이름을 입력하세요: ");
		String name = scanner.next();

		System.out.print("직원 이메일을 입력하세요: ");
		String email = scanner.next();

		System.out.print("직원 전화번호를 입력하세요: ");
		String phoneNumber = scanner.next();

		System.out.print("직원 입사일을 입력하세요(yyyy-MM-dd): ");
		LocalDate hireDate = LocalDate.parse(scanner.next());

		System.out.print("직원 월급을 입력하세요: ");
		int salary = scanner.nextInt();

		System.out.print("직무 아이디를 입력하세요: ");
		String jobId = scanner.next();

		System.out.print("직무 타이틀을 입력하세요: ");
		String jobTitle = scanner.next();

		System.out.print("최소 월급을 입력하세요: ");
		int minSalary = scanner.nextInt();

		System.out.print("최대 월급을 입력하세요: ");
		int maxSalary = scanner.nextInt();

		System.out.print("근무 기록 아이디를 입력하세요: ");
		String jobHistoryId = scanner.next();

		System.out.print("근무 시작일을 입력하세요(yyyy-MM-dd): ");
		LocalDate startDate = LocalDate.parse(scanner.next());

		System.out.print("근무 종료일을 입력하세요(yyyy-MM-dd): ");
		LocalDate endDate = LocalDate.parse(scanner.next());

		// 입력받은 정보를 객체로 생성
		Employee employee = new Employee(employeeId, name, email, phoneNumber, hireDate, salary);
		Jobs jobs = new Jobs(jobId, jobTitle, minSalary, maxSalary);
		JobHistory jobHistory = new JobHistory(jobHistoryId, startDate, endDate);

		try {
			serviceCreate.createEJH(employee, jobs, jobHistory);
			System.out.println("저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
