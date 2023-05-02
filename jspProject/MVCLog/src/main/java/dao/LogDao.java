//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//
//import domain.UserLog;
//
//public class LogDao {
//
//	private LogDao() {
//	}
//
//	private static LogDao logDao = new LogDao();
//
//	public static LogDao getInstance() {
//		return logDao;
//	}
//
//	public void insertPasswordChangeRequiredLog(Connection conn, String id) {
//		PreparedStatement ps = null;
//		try {
//			String query = "INSERT INTO USER_LOGS(id, timestamp) VALUES (?, ?)";
//			ps = conn.prepareStatement(query);
//			ps.setString(1, id);
//			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
