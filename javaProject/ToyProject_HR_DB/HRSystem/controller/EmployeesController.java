package controller;


import java.sql.SQLException;
import java.util.Scanner;
import dao.EmployeesDAO;
import domain.Employees;

public class EmployeesController {

	// 인스턴스 변수 정의 
	private EmployeesDAO employeesDAO;

	// 생성자로 EmployeesDAO 초기화 
	public EmployeesController() {
		this.employeesDAO = employeesDAO;
	}
	

	// create employee console
	public void createEmployeeConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 사원 정보 생성 ===");
		System.out.println("사원id,name,email,number,hiredate");
		System.out.println("사원 id입력: ");
		String employee_id = scan.nextLine().trim();
		System.out.println("사원 name입력: ");
		String name = scan.nextLine().trim();
		System.out.println("사원 email입력: ");
		String email = scan.nextLine().trim();
		System.out.println("사원 phone_number입력: ");
		String phone_number = scan.nextLine().trim();
		System.out.println("사원 hiredate입력: ");
		String hiredate = scan.nextLine().trim();

		Employees employees = new Employees(employee_id, name, email, phone_number, hiredate);
		try {
			employeesDAO.create(employees);
			System.out.println("=== 사원 정보 생성 완료! ===");
		} catch (SQLException e) {
			System.out.println("=== 사원 정보 생성 실패! ===");
		}
	}

	// read employee console
	public void readEmployeeConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 사원 정보 조회 ===");
		System.out.println("사원 이름 입력: ");
		String name = scan.nextLine().trim();
		try {
			Employees employees = employeesDAO.read(name);
			if (employees == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println("=============================");
				System.out.println("사원 ID: " + employees.getEmployee_id());
				System.out.println("이름: " + employees.getName());
				System.out.println("이메일: " + employees.getEmail());
				System.out.println("전화번호: " + employees.getPhone_number());
				System.out.println("고용일: " + employees.getHiredate());
				System.out.println("=============================");
			}
		} catch (SQLException e) {
			System.out.println("=== 사원 정보 조회 실패! ===");
		}
	}

	// update employee console
	public void updateEmployeeConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 사원 정보 업데이트 ===");
		String name = scan.nextLine().trim();
		try {
			Employees employees = employeesDAO.read(name);
			if (employees == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println(employees.getName() + " 의 사원 정보 수정");
				System.out.println("new id 입력: ");
				String newId = scan.nextLine().trim();
				System.out.println("new name 입력: ");
				String newName = scan.nextLine().trim();
				System.out.println("new email 입력: ");
				String newEmail = scan.nextLine().trim();
				System.out.println("new phone_number 입력: ");
				String newPhone_nummber = scan.nextLine().trim();
				System.out.println("new hiredate 입력: ");
				String newHiredate = scan.nextLine().trim();

				Employees newEmployees = new Employees(newId, newName, newEmail, newPhone_nummber, newHiredate);
				newEmployees.setEmployee_id(newId);
				newEmployees.setName(newName);
				newEmployees.setEmail(newEmail);
				newEmployees.setPhone_number(newPhone_nummber);
				newEmployees.setHiredate(newHiredate);

				Employees updateEmployees = employeesDAO.update(newName, newEmployees);
				if (updateEmployees != null) {
					System.out.println("=== 사원 정보 업데이트 완료 ===");
				} else {
					System.out.println("=== 사원 정보 업데이트 실패 ===");
				}
			}
		} catch (SQLException e) {
			System.out.println("=== 사원 정보 업데이트 실패 ===");
		}
	}

	// delete employee console
	public void deleteEmployeeConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 사원 정보 삭제 ===");
		System.out.println("사원 이름 입력:");
		String name = scan.nextLine().trim();
		try {
			Employees employees = employeesDAO.read(name);
			if (employees == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println(employees.getName() + " 님 의 사원 정보 삭제");
				employeesDAO.delete(name);
			}
		} catch (SQLException e) {
			System.out.println("=== 사원 정보 삭제 실패 ===");
		}
	}
}
