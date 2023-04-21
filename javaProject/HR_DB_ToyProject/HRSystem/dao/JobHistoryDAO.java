package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import domain.JobHistory;

public class JobHistoryDAO {

	// SQL jobHistory create
	public void createHistory(Connection conn, JobHistory jobHistory) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO job_history(job_history_id, start_date, end_date) VALUES (?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobHistory.getJob_history_id());
			ps.setDate(2, java.sql.Date.valueOf(jobHistory.getStart_date()));
			ps.setDate(3, java.sql.Date.valueOf(jobHistory.getEnd_date()));
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL jobHistory read
	public List<JobHistory> readAllHistory(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<JobHistory> result = new ArrayList<>();
		try {
			String query = "SELECT * FROM job_history";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				JobHistory jobHistory = new JobHistory(rs.getString("job_history_id"),
						rs.getDate("start_date").toLocalDate(), rs.getDate("end_date").toLocalDate());
				result.add(jobHistory);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return result;
	}

	// SQL jobHistory update
	public void updateHistory(Connection conn, JobHistory jobHistory) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "UPDATE job_history SET start_date=?, end_date=? WHERE job_history_id =?";
			ps = conn.prepareStatement(query);
			ps.setDate(1, java.sql.Date.valueOf(jobHistory.getStart_date()));
			ps.setDate(2, java.sql.Date.valueOf(jobHistory.getEnd_date()));
			ps.executeUpdate();
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}
	
	
//	// SQL jobHisotry delete
//	public void deleteHistory(Connection conn, JobHistory jobHistory) throws SQLException {
//		
//	}
	
	
	
	
}