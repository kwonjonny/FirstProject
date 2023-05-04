package dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.sql.Date;

public class PasswordRequiredDao {

	// default 생성자 정의
	private PasswordRequiredDao() {
	}

	// singleton pattern
	private static PasswordRequiredDao dao = new PasswordRequiredDao();

	// service에서 필요한 getIsntance 생성
	public static PasswordRequiredDao getInstance() {
		return dao;
	}

	public boolean isPasswordChangeRequired(Connection conn, String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			String query = "SELECT last_password_change, passwordChangeInterval FROM USERS WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Date lastPasswordChange = rs.getDate("last_password_change");
				int passwordChangeInterval = rs.getInt("passwordChangeInterval");

				long daysSinceLastChange = TimeUnit.MILLISECONDS
						.toDays(System.currentTimeMillis() - lastPasswordChange.getTime());
				if (daysSinceLastChange >= passwordChangeInterval) {
					result = true;
				}
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

}
