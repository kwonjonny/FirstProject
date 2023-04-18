package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

// Resultset --> SQL쿼리를 실행한 결과를 담고 있는 객체 
// DB에서 가져온 결과 집합을 담고있다 

// PreparedStatement --> SQL문장을 미리 컴파일하여 저장, 후 에 실행시 컴파일 단계를 생략하고
// 바로 실행하는 객체 --> SQL실행 시간 단축 가능 
// 또한 PreparedStatement 는 보안 측면에서도 안전하다 
// 입력값으로부터 SQL injection 공격을 방지
// PreparedStatement 객체는 ? 를 사용하여 값을 설정 가능 실행 시 바인딩 변수의 값을 파라미터로 전달하여 SQL문장 실행

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

	// SQL Create
	public void create(User user) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO UserTable(id,username,password,name,email,address,phone,grade,createDate,role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPhone());
			ps.setInt(8, user.getGrade());
			ps.setDate(9, user.getCreateDate());
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
			String query = "SELECT * FROM UserTable WHERE id = ? AND password = ?";
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
				user = new User(id, " ", " ", " ", " ", " ", " ", 0, null, " ");
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
			// id와 password 확인
			String query = "SELECT * FROM userTable WHERE id = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (!rs.next()) {
				// if id,password ok -> logic go
				return null;
			}
			String queryUpdate = "UPDATE userTable SET id = ? , username = ? password = ? , name =? , email = ? , address = ? , phone = ? , grade = ? , createDate = ? , role = ? , WHERE id = ? ";
			ps = conn.prepareStatement(queryUpdate);
			ps.setString(1, newUser.getId());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getName());
			ps.setString(5, newUser.getEmail());
			ps.setString(6, newUser.getAddress());
			ps.setString(7, newUser.getPhone());
			ps.setInt(8, newUser.getGrade());
			ps.setDate(9, newUser.getCreateDate());
			ps.setString(10, newUser.getRole());
			ps.setString(11, id);

			int updateRows = ps.executeUpdate();
			if (updateRows > 0) {
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
