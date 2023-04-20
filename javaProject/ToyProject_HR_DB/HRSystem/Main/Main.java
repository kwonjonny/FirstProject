package Main;

import service.EmployeeJobService;
import java.util.Scanner;
import controller.ServiceController;
import dao.JobHistoryDAO;
import dao.EmployeesDAO;
import dao.JobsDAO;

public class Main {
	public static void main(String[]args) {
		 // EmployeesDAO, JobsDAO, JobHistoryDAO 객체를 생성합니다.
	    EmployeesDAO employeesDAO = new EmployeesDAO();
	    JobsDAO jobsDAO = new JobsDAO();
	    JobHistoryDAO jobHistoryDAO = new JobHistoryDAO();

	    // EmployeeJobService 객체를 생성합니다.
	    EmployeeJobService employeeJobService = new EmployeeJobService(employeesDAO, jobsDAO, jobHistoryDAO);

	    // ServiceController 객체를 생성합니다.
	    ServiceController serviceController = new ServiceController(employeeJobService);

	    // ServiceController 클래스의 EmployeeJobStart 메소드를 실행합니다.
	    serviceController.EmployeeJobStart();
		
	}
	}

