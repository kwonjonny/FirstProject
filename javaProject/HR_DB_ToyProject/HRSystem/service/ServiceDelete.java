package service;

import dao.EmployeeDAO;
import dao.JobHistoryDAO;
import dao.JobsDAO;

public class ServiceDelete {
	
	private EmployeeDAO employeeDAO;
	private JobsDAO jobsDAO;
	private JobHistoryDAO jobHistoryDAO;

	public ServiceDelete(EmployeeDAO employeeDAO, JobsDAO jobsDAO, JobHistoryDAO jobHistoryDAO) {
		this.employeeDAO = employeeDAO;
		this.jobsDAO = jobsDAO;
		this.jobHistoryDAO = jobHistoryDAO;
	}
	
	
}
