package service;

import dao.EmployeeDAO;
import dao.JobsDAO;
import dao.JobHistoryDAO;

import domain.Jobs;
import domain.Employee;
import domain.JobHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConnection.DBConnection;

public class ServiceCreate {

	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceCreate(EmployeeDAO employeeDAO, JobsDAO jobsDAO, JobHistoryDAO jobHistoryDAO) {
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}

	public void createEJH(Employee employee, Jobs jobs, JobHistory jobHistory) throws SQLException {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			employeeDAO.createEmployee(conn, employee);
			jobsDAO.createJob(conn, jobs);
			jobHistoryDAO.createHistory(conn, jobHistory);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("");
			throw e;
		} finally {
			conn.close();
			System.out.println("");
		}
	}

}
