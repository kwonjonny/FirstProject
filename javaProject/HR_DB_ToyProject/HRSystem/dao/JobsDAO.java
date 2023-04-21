package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import domain.Jobs;
import java.util.ArrayList;

public class JobsDAO {

	/// SQL Job create
	public void createJob(Connection conn, Jobs jobs) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO Jobs(job_id, job_title, min_salary, max_salary) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobs.getJob_id());
			ps.setString(2, jobs.getJob_title());
			ps.setInt(3, jobs.getMin_salary());
			ps.setInt(4, jobs.getMax_salary());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL Job read
	public List<Jobs> readAllJobs(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Jobs> result = new ArrayList<>();
		try {
			String query = "SELECT * FROM Jobs";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Jobs job = new Jobs(rs.getString("job_id"), rs.getString("job_title"), rs.getInt("min_salary"),
						rs.getInt("max_salary"));
				result.add(job);
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
	
	// SQL Job update
	public void updateJob(Connection conn, Jobs job) throws SQLException {
	    PreparedStatement ps = null;
	    try {
	        String query = "UPDATE Jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id =?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, job.getJob_title());
	        ps.setInt(2, job.getMin_salary());
	        ps.setInt(3, job.getMax_salary());
	        ps.executeUpdate();
	    } finally {
	        if (ps != null) {
	            ps.close();
	        }
	    }
	}

		
	// SQL job delete
	public void deleteJob(Connection conn) throws SQLException {

	}
	
	
}