//package dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.sql.Connection;
//import java.sql.Date;
//
//public class PasswordChangeRequiredDao {
//
//	private PasswordChangeRequiredDao() {
//	}
//
//	private static PasswordChangeRequiredDao changeDao = new PasswordChangeRequiredDao();
//
//	public static PasswordChangeRequiredDao getInstance() {
//		return changeDao;
//	}
//
//	public boolean isPasswordChangeRequired(Connection conn, String id) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			String query = "SELECT last_password_change, passwordChangeInterval FROM USERS WHERE id=?";
//			ps = conn.prepareStatement(query);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				LocalDate lastPasswordChange = rs.getDate("last_password_change").toLocalDate();
//				int passwordChangeInterval = rs.getInt("passwordChangeInterval");
//				LocalDate nextPasswordChange = lastPasswordChange.plusMonths(passwordChangeInterval);
//				return LocalDate.now().isAfter(nextPasswordChange);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
//}
