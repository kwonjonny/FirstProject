package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDao {

	private static UserDao instance;
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	// singleton instance
	public static UserDao getInstance(Connection conn) {
		if (instance == null) {
			instance = new UserDao(conn);
		}
		return instance;
	}

	// SQL create
	public void create(User user) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO UserTable(id, username, password, name, email, address, phone, grade, createDate, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPhone());
			ps.setInt(8, user.getGrade());
			ps.setDate(9, user.getCreatDate());
			ps.setString(10, user.getRole());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL read
	public User read(String id, String password) throws SQLException {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM UserTable WHERE id = ? AND password = ? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("name"), rs.getString("email"), rs.getString("address"), rs.getString("phone"),
						rs.getInt("grade"), rs.getDate("createDate"), rs.getString("role"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return user;
	}

	// SQL delete
	public User delete(String id, String password) throws SQLException {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "DELETE FROM userTable WHERE id = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			int count = ps.executeUpdate();
			if (count > 0) {
				user = new User(id, "", "", "", "", "", "", 0, null, "");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return user;
	}

	// SQL update
	public User update(String id, String password, User newUser) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// id 와 password 확인
			String queryCheck = "SELECT id FROM userTable WHERE id = ? AND password = ?";
			ps = conn.prepareStatement(queryCheck);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (!rs.next()) {
				// if id, password 맞을시 로직 실행
				return null;
			}
			// user information 업데이트
			String queryUpdate = "UPDATE userTable SET id = ?, username = ?, password = ?, name = ?, email = ?, address = ?, phone = ?, grade = ?, createDate = ?, role = ? WHERE id = ?";
			ps = conn.prepareStatement(queryUpdate);
			ps.setString(1, newUser.getId());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getName());
			ps.setString(5, newUser.getEmail());
			ps.setString(6, newUser.getAddress());
			ps.setString(7, newUser.getPhone());
			ps.setInt(8, newUser.getGrade());
			ps.setDate(9, newUser.getCreatDate());
			ps.setString(10, newUser.getRole());
			ps.setString(11, id);

			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				return newUser;
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
}
