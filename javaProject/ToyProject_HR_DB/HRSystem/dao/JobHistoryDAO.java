package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import domain.JobHistory;
import service.EmployeeJobService;;

public class JobHistoryDAO {



	// SQL JobHistory create
	public void historyCreate(Connection conn, JobHistory jobHistory) throws SQLException {
	    PreparedStatement ps = null;
	    
	    try {
	        String query = "INSERT INTO JOB_HISTORY(employee_id, start_date, end_date, jobs_id) VALUES (?,?,?,?)";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, jobHistory.getEmployee_id());
	        ps.setDate(2, java.sql.Date.valueOf(jobHistory.getStart_date()));
	        ps.setDate(3, java.sql.Date.valueOf(jobHistory.getEnd_date()));
	        ps.setString(4, jobHistory.getJobs_id());
	        ps.executeUpdate();
	        System.out.println("JobHistory created successfully");
	    } catch (SQLException e) {
	        System.out.println("JobHistory creation failed");
	        e.printStackTrace();
	    } finally {
	        if (ps != null) {
	            ps.close();
	        }
	    }
	}

	// SQL JobHistory read
	public JobHistory historyReadById(Connection conn, String employee_id, String jobs_id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JobHistory jobHistory = null;
		try {
			String query = "SELECT * FROM JOB_HISTORY WHERE employee_id = ? AND jobs_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, employee_id);
			ps.setString(2, jobs_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				jobHistory = new JobHistory(rs.getString("employee_id"), rs.getDate("start_date").toLocalDate(),
						rs.getDate("end_date").toLocalDate(), rs.getString("jobs_id"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return jobHistory;
	}

	// SQL JobHistory update
	public JobHistory historyUpdateById(Connection conn,String employee_id, String jobs_id, JobHistory newJobHistory) throws SQLException {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM JOB_HISTORY WHERE employee_id = ? AND jobs_id = ?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, employee_id);
	        ps.setString(2, jobs_id);
	        rs = ps.executeQuery();
	        if (!rs.next()) {
	            throw new SQLException("No record found for " + employee_id + " " + jobs_id);
	        }

	        String queryUpdate = "UPDATE JOB_HISTORY SET start_date = ?, end_date = ? WHERE employee_id = ? AND jobs_id = ?";
	        ps = conn.prepareStatement(queryUpdate);
	        
	        ps.setString(1, newJobHistory.getEmployee_id());
	        ps.setDate(1, java.sql.Date.valueOf(newJobHistory.getStart_date()));
	        ps.setDate(2, java.sql.Date.valueOf(newJobHistory.getEnd_date()));
	        ps.setString(4, newJobHistory.getJobs_id());
	        ps.setString(3, employee_id);
	        ps.setString(4, jobs_id);

	        int updateRows = ps.executeUpdate();
	        if (updateRows > 0) {
	            return newJobHistory;
	        } else {
	            return null;
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (ps != null) {
	            ps.close();
	        }
	    }
	}

	// SQL JobHistory delete
	public void historyDeleteById(Connection conn,String employee_id, String jobs_id) throws SQLException {
		PreparedStatement ps = null;
		try {
			String querydelete = "DELETE FROM JOB_HISTORY WHERE employee_id = ? AND jobs_id = ?";
			ps = conn.prepareStatement(querydelete);
			ps.setString(1, employee_id);
			ps.setString(2, jobs_id);

			int deleteRows = ps.executeUpdate();
			if (deleteRows > 0) {
				System.out.println("JobHistory deleted successfully");
			} else {
				throw new SQLException("Failed to delete JobHistory");
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	
}
