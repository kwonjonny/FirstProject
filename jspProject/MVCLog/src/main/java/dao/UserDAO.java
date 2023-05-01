package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDao {

	// default 생성자 정의
	private UserDao() {
	}

	// singleton pattern
	private static UserDao dao = new UserDao();

	// getInstance 생성
	public static UserDao getInstance() {
		return dao;
	}

	// loginUser 로직
	public User findLogin(Connection conn, String id, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			String query = "SELECT * FROM USERS WHERE id =? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				String username = rs.getString("username");
				String email = rs.getString("email");
				user = new User(username, id, password, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;

	}

	// ListUser 로직
	public List<User> getUserList(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> result = new ArrayList<>();

		try {
			String query = "SELECT * FROM USERS";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				User user = new User(username, id, password, email);
				result.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// createUser 로직
	public int createUser(Connection conn, User user) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "INSERT INTO USERS(username,email,id,password) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getId());
			ps.setString(4, user.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// readUser 로직
	public User readUser(Connection conn, String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User result = null;
		try {
			String query = "SELECT * FROM USERS WHERE id =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getNString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// updateUser 로직
	public int updateUser(Connection conn, User user) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "UPDATE USERS SET username=?, email=?, password=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// deleteUser 로직
	public int deleteUser(Connection conn, String id) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "DELETE FROM USERS WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// Email 로직
	public User findByEmail(Connection conn, String email) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User result = null;
		try {
			String query = "SELECT * FROM USERS WHERE email = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"),
						rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					;
				}
			}
		}
		return result;
	}
}
