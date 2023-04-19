package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Jobs;

public class JobsDAO {
	
	// 인스턴스 변수 정의
	// singleton pattern
	private static JobsDAO instance;
	private Connection conn;

	// 생성자로 connection 초기화
	public JobsDAO(Connection conn) {
		this.conn = conn;
	}

	// JobsDAO 클래스의 인스턴스가 한 번만 생성되며 생성된 인스턴스에서는
	// 인스턴스를 사용하여 Connection 객체를 얻어올 수 있다
	public static JobsDAO getInstance(Connection conn) {
		if (instance == null) {
			instance = new JobsDAO(conn);
		} else {
			instance.conn = conn;
		}
		return instance;
	}

	// SQL Jobs create
	public void JobsCreate(Jobs jobs) throws SQLException {
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
	public Jobs JobsRead(String jobs_id) throws SQLException {
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
	public Jobs JobsUpdate(String jobs_id, Jobs newJobs) throws SQLException {
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
	public Jobs delete(String jobs_id) throws SQLException {
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
