//package servicePasswordChange;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import dao.LogDao;
//import dao.PasswordChangeRequiredDao;
//import util.DBConnection;
//
//public class ChangeServicePassword {
//
//	private PasswordChangeRequiredDao changeDao;
//	private LogDao logDao;
//
//	private static ChangeServicePassword changeService = new ChangeServicePassword();
//
//	public ChangeServicePassword() {
//		this.changeDao = PasswordChangeRequiredDao.getInstance();
//		this.logDao = LogDao.getInstance();
//	}
//	
//	public static ChangeServicePassword getInstance() {
//		return changeService;
//	}
//
//	public void checkPasswordChangeRequired(String id) {
//		Connection conn = null;
//		try {
//			conn = DBConnection.getConnection();
//			conn.setAutoCommit(false);
//			if (changeDao.isPasswordChangeRequired(conn, id)) {
//				logDao.insertPasswordChangeRequiredLog(conn, id);
//				conn.commit();
//			}
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