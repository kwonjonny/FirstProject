//package servicePasswordChange;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import dao.LogDao;
//import util.DBConnection;
//
//public class ChangeServiceLog {
//
//	private LogDao logDao;
//
//	private static ChangeServiceLog serviceLog = new ChangeServiceLog();
//
//	public ChangeServiceLog() {
//		this.logDao = LogDao.getInstance();
//	}
//
//	public static ChangeServiceLog getInstance() {
//		return serviceLog;
//	}
//
//	public void logPasswordChangeRequired(String id) {
//		Connection conn = null;
//		try {
//			conn = DBConnection.getConnection();
//			conn.setAutoCommit(false);
//			logDao.insertPasswordChangeRequiredLog(conn, id);
//			conn.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			if (conn != null) {
//				try {
//					conn.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//}