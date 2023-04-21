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

public class ServiceRead {

	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceRead(EmployeeDAO employeeDAO, JobsDAO jobsDAO, JobHistoryDAO jobHistoryDAO) {
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}
	
	public void readEJH() throws SQLException {
	    Connection conn = null;
	    try {
	        conn = DBConnection.getConnection();
	        conn.setAutoCommit(false);
	        List<Employee> employee = employeeDAO.readAllEmployees(conn);
	        List<Jobs> jobs = jobsDAO.readAllJobs(conn);
	        List<JobHistory> jobHistory = jobHistoryDAO.readAllHistory(conn);
	        System.out.println(employee.toString());
	        System.out.println(jobs.toString());
	        System.out.println(jobHistory.toString());
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
