package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.EmployeesDAO;
import dao.JobHistoryDAO;
import dao.JobsDAO;
import dbConnection.DBConnection;
import domain.Employees;
import domain.Jobs;
import domain.JobHistory;

public class EmployeeJobService {

	// 각각의 DAO 클래스 인스턴스 변수로 정의
	private EmployeesDAO employeesDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;
	// private Connection conn;

	// 인스턴스를 생성자로 초기화 함 으로써 DBConnection 과 sql 로직 실행 가능
	public EmployeeJobService(EmployeesDAO employeesDAO, JobsDAO jobsDAO, JobHistoryDAO jobHistoryDAO) {
		this.employeesDAO = employeesDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}

	// JobsEmployeeServcie 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 생성하는
	// 메소드를 구현
	public void createJobsAndEmployees(Jobs job, Employees employees, JobHistory jobHistory) throws SQLException {

		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			jobsDAO.JobsCreate(conn, job);
			employeesDAO.create(conn, employees);
			jobHistoryDAO.historyCreate(conn, jobHistory);

			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("사원과 직업 정보 생성 실패 " + e.getMessage());
			throw e;
		} finally {
			conn.close();
			System.out.println("=== 사원과 직업 정보 생성 완료 ===");
		}
	}

	// JObsEmployeeService 클래스에서는 JodbDAO EmployeesDAO를 사용하여 Jobs와 Employees를 읽는
	// 메소드를 구현
	public void readJobsAndEmployees(String jobs_id, String name, String employeeId, String jobId) throws SQLException {

		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			Jobs jobs = jobsDAO.JobsRead(conn, jobs_id);
			Employees employees = employeesDAO.read(conn, name);
			JobHistory jobHistory = jobHistoryDAO.historyReadById(conn, employeeId, jobId);

			System.out.println("직업 정보 " + jobs.toString());
			System.out.println("사원 정보 " + employees.toString());
			System.out.println("입사 퇴사 정보: " + jobHistory.toString());
			conn.commit();
		} catch (SQLException e) {
			System.out.println("정보 출력 실패: " + e.getMessage());
			conn.rollback();
			throw e;
		} finally {
			conn.close();
			System.out.println("=== 사원과 직업 정보 출력 완료 ===");
		}
	}

	// JobsEmployeeService 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 update
	// 하는 메소드를 구현
	public void updateJobsAndEmployees(String jobs_id, Jobs newJobs, String employee_id, Employees newEmployees,
	        LocalDate existingStartDate, JobHistory newJobHistory) throws SQLException {
	    Connection conn = null;

	    try {
	        conn = DBConnection.getConnection();
	        conn.setAutoCommit(false);
	        jobHistoryDAO.historyUpdateById(conn, existingStartDate, newJobHistory);
	        jobsDAO.JobsUpdate(conn, jobs_id, newJobs);
	        employeesDAO.update(conn, employee_id, newEmployees);
	        conn.commit();

	        System.out.println("=== 사원과 직업 정보 업데이트 완료 ===");
	    } catch (SQLException e) {
	        conn.rollback();
	        System.out.println("사원과 직업 정보 업데이트 실패: " + e.getMessage());
	        throw e;
	    } finally {
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}



	// JobsEmployeeService 클래스에서는 JobDAO EmployeesDAO를 사용하여 Jobs와 Employees를 update
	// 하는 메소드를 구현
	public void deleteJobsAndEmployees(String jobId, String name, String employee_id, String jobIdHistory)
			throws SQLException {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			jobHistoryDAO.historyDeleteById(conn, employee_id);
			employeesDAO.delete(conn, name);
			jobsDAO.delete(conn, jobIdHistory);
			conn.commit();
			System.out.println("=== 사원과 직업 정보 삭제 완료 ===");
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("사원과 직업 정보 삭제 실패: " + e.getMessage());
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
