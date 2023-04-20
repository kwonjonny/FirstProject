package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import service.EmployeeJobService;
import domain.Jobs;

public class JobsDAO {
	
	// SQL Jobs create
	public void JobsCreate(Connection conn,Jobs jobs) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO JOBS(jobs_id, jobs_title, jobs_description, salary) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobs.getJobs_id());
			ps.setString(2, jobs.getJobs_title());
			ps.setString(3, jobs.getJobs_description());
			ps.setInt(4, jobs.getSalary());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL Jobs read
	public Jobs JobsRead(Connection conn, String jobs_id) throws SQLException {
		Jobs jobs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM JOBS WHERE jobs_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobs_id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("NO reocord found for " + jobs_id);
			}
			jobs = new Jobs(rs.getString("jobs_id"), rs.getString("jobs_title"), rs.getString("jobs_description"),
					rs.getInt("salary"));
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return jobs;
	}

	// SQL Jobs update
	public Jobs JobsUpdate(Connection conn, String jobs_id, Jobs newJobs) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM JOBS WHERE jobs_id =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobs_id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No record found for " + jobs_id);
			}

			String queryUpdate = "UPDATE Jobs SET jobs_id = ?, jobs_title = ?, jobs_description = ?, salary = ? WHERE jobs_id = ?";
			ps = conn.prepareStatement(queryUpdate);
			ps.setString(1, newJobs.getJobs_id());
			ps.setString(2, newJobs.getJobs_title());
			ps.setString(3, newJobs.getJobs_description());
			ps.setInt(4, newJobs.getSalary());
			ps.setString(5, jobs_id);

			int updateRows = ps.executeUpdate();
			if (updateRows > 0) {
				return newJobs;
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

	// SQL Jobs JobsDelete
	public Jobs delete(Connection conn, String jobs_id) throws SQLException {
		Jobs jobs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM JOBS WHERE jobs_id = ? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, jobs_id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No record found for " + jobs_id);
			}
			jobs = new Jobs(rs.getString("jobs_id"), rs.getString("jobs_title"), rs.getString("jobs_description"),
					rs.getInt("salary"));

			String queryDelete = "DELETE FROM JOBS WHERE jobs_id =?";
			ps = conn.prepareStatement(queryDelete);
			ps.setString(1, jobs_id);
			int deleteRows = ps.executeUpdate();
			if (deleteRows > 0) {
				return jobs;
			} else {
				return null;
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				rs.close();
			}
		}
	}
}
