package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDAO;
import dao.JobHistoryDAO;
import dao.JobsDAO;
import dbConnection.DBConnection;
import domain.Employee;
import domain.JobHistory;
import domain.Jobs;

public class ServiceUpdate {
	
	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceUpdate(EmployeeDAO employeeDAO, JobsDAO jobsDAO, JobHistoryDAO jobHistoryDAO) {
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}
	
	public void updateEJH(Employee employee, Jobs job, JobHistory jobHistory) throws SQLException {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
	        
			employeeDAO.updateEmployee(conn, employee);
			jobsDAO.updateJob(conn, job);
			jobHistoryDAO.updateHistory(conn, jobHistory);
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
