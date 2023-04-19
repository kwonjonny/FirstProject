package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmployeesDAO;
import dao.JobsDAO;
import model.Employees;
import model.Jobs;

public class EmployeeJobService {

	// 각각의 DAO 클래스 인스턴스 변수로 정의
	private EmployeesDAO employeesDAO;
	private JobsDAO jobsDAO;
	private Connection conn;

	// 인스턴스를 생성자로 초기화 함 으로써 DBConnection 과 sql 로직 실행 가능
	public EmployeeJobService(Connection conn,EmployeesDAO employeesDAO, JobsDAO jobsDAO) {
		this.employeesDAO = employeesDAO;
		this.jobsDAO = jobsDAO;
		this.conn = conn;
	}

	// JobsEmployeeServcie 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 생성하는
	// 메소드를 구현
	public void createJobsAndEmployees(Jobs job, Employees employees) throws SQLException {
		conn.setAutoCommit(false);

		try {
			jobsDAO.JobsCreate(job);
			employeesDAO.create(employees);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("사원과 직업 정보 생성 실패 " + e.getMessage());
			throw e;
		} finally {
			System.out.println("=== 사원과 직업 정보 생성 완료 ===");
			conn.setAutoCommit(true);
		}
	}

	// JObsEmployeeService 클래스에서는 JodbDAO EmployeesDAO를 사용하여 Jobs와 Employees를 읽는
	// 메소드를 구현
	public void readJobsAndEmployees(String jobs_id, String name) throws SQLException {
		try {
			Jobs jobs = jobsDAO.JobsRead(jobs_id);
			Employees employees = employeesDAO.read(name);
			System.out.println("직업 정보 " + jobs.toString());
			System.out.println("사원 정보 " + employees.toString());
		} catch (SQLException e) {
			System.out.println("정보 출력 실패: " + e.getMessage());
			throw e;
		} finally {
			System.out.println("=== 사원과 직업 정보 출력 완료 ===");
		}
	}

	// JobsEmployeeService 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 update
	// 하는 메소드를 구현
	public void updateJobsAndEmployees(String jobs_id, Jobs newJobs, String name, Employees newEmployees)
			throws SQLException {
		conn.setAutoCommit(false);
		try {
			Jobs jobs = jobsDAO.JobsUpdate(jobs_id, newJobs);
			Employees employees = employeesDAO.update(name, newEmployees);
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("사원과 직업 정보 업데이트 실패: " + e.getMessage());
			throw e;
		} finally {
			conn.setAutoCommit(true);
			System.out.println("=== 사원과 직업 정보 업데이트 완료 ===");
		}
	}

	// JobsEmployeeService 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 delete
	// 하는 메소드를 구현
	public void deleteJobsAndEmployees(String jobs_id, String name) throws SQLException {
		conn.setAutoCommit(false);
		try {
			jobsDAO.delete(jobs_id);
			employeesDAO.delete(name);
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("사원과 직업 정보 삭제 실패: " + e.getMessage());
			throw e;
		} finally {
			System.out.println("=== 사원과 직업 정보 삭제 완료 ===");
			conn.setAutoCommit(true);
		}
	}
}
