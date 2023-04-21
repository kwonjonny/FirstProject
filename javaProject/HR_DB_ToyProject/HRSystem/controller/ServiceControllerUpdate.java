package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dao.JobHistoryDAO;
import dao.JobsDAO;
import dbConnection.DBConnection;
import domain.Employee;
import domain.JobHistory;
import domain.Jobs;
import service.ServiceCreate;
import service.ServiceRead;
import service.ServiceUpdate;

public class ServiceControllerUpdate {

	private ServiceUpdate serviceUpdate;
	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceControllerUpdate(ServiceUpdate serviceUpdate,EmployeeDAO employeeDAO, JobsDAO jobsDAO,JobHistoryDAO jobHistoryDAO) {
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
		this.serviceUpdate = serviceUpdate;
	}

	public void update() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		// 입력받은 정보를 저장할 변수들
		String employee_id, name, email, phone_number, job_id, job_title;
		int salary, min_salary, max_salary;
		LocalDate hire_date, start_date, end_date;

		System.out.println("Enter employee_id: ");
		employee_id = scanner.nextLine();

		System.out.println("Enter name: ");
		name = scanner.nextLine();

		System.out.println("Enter email: ");
		email = scanner.nextLine();

		System.out.println("Enter phone_number: ");
		phone_number = scanner.nextLine();

		System.out.println("Enter hire_date (YYYY-MM-DD): ");
		hire_date = LocalDate.parse(scanner.nextLine());

		System.out.println("Enter salary: ");
		salary = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter job_id: ");
		job_id = scanner.nextLine();

		System.out.println("Enter job_title: ");
		job_title = scanner.nextLine();

		System.out.println("Enter min_salary: ");
		min_salary = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter max_salary: ");
		max_salary = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter job_history_id: ");
		String job_history_id = scanner.nextLine();

		System.out.println("Enter start_date (YYYY-MM-DD): ");
		start_date = LocalDate.parse(scanner.nextLine());

		System.out.println("Enter end_date (YYYY-MM-DD): ");
		end_date = LocalDate.parse(scanner.nextLine());

		// 업데이트할 Employee, Jobs, JobHistory 객체 생성
		Employee employee = new Employee(employee_id, name, email, phone_number, hire_date, salary);
		Jobs job = new Jobs(job_id, job_title, min_salary, max_salary);
		JobHistory jobHistory = new JobHistory(job_history_id, start_date, end_date);

		try {
			serviceUpdate.updateEJH(employee, job, jobHistory);
			System.out.println("저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
