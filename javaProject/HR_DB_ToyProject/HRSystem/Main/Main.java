package Main;

import dao.JobHistoryDAO;
import dao.EmployeeDAO;
import dao.JobsDAO;
import domain.Employee;
import domain.JobHistory;
import domain.Jobs;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import controller.ServiceControllerUpdate;
import controller.ServiceControllerCreate;
import controller.ServiceControllerRead;

import service.ServiceRead;
import service.ServiceCreate;
import service.ServiceUpdate;
import service.ServiceDelete;

public class Main {

	public static void main(String[] args) throws SQLException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		JobsDAO jobDAO = new JobsDAO();
		JobHistoryDAO jobHistoryDAO = new JobHistoryDAO();

		ServiceCreate serviceCreate = new ServiceCreate(employeeDAO, jobDAO, jobHistoryDAO);
		ServiceRead serviceRead = new ServiceRead(employeeDAO, jobDAO, jobHistoryDAO);
		ServiceUpdate serviceUpdate = new ServiceUpdate(employeeDAO, jobDAO, jobHistoryDAO);

		ServiceControllerCreate sv = new ServiceControllerCreate(serviceCreate, employeeDAO, jobDAO, jobHistoryDAO);
		ServiceControllerUpdate sp = new ServiceControllerUpdate(serviceUpdate, employeeDAO, jobDAO, jobHistoryDAO);
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("원하는 작업을 선택해주세요.");
			System.out.println("1. 사원 정보 입력");
			System.out.println("2. 사원 정보 출력");
			System.out.println("3. 사원 정보 수정");
			System.out.println("4. 사원 정보 삭제");
			System.out.println("5. 종료");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				sv.create();
				break;
			case 2:
				serviceRead.readEJH();
				break;
			case 3:
				serviceRead.readEJH();
				sp.update();
				break;
			case 4:
				// 사원, 직무, 업무 이력 정보 출력 기능 실행
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
	}

}