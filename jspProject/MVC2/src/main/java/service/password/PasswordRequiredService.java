package service.password;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import dao.auth.PasswordRequiredDao;
import dao.user.UserDao;
import domain.User;
import util.DB.DBConnection;

public class PasswordRequiredService {

	// PasswordRequiredDao 인스턴스 생성
	private PasswordRequiredDao dao;
	private UserDao userDao;

	// singleton pattern
	private static PasswordRequiredService service = new PasswordRequiredService();

	// PasswordRequiredDao 의 인스턴스 가져옴
	public PasswordRequiredService() {
		this.dao = PasswordRequiredDao.getInstance();
		this.userDao = UserDao.getInstance();
	}

	// controller에서 필요한 getIsntance 생성
	public static PasswordRequiredService getInstance() {
		return service;
	}

	public boolean isPasswordChangeRequired(String id) {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			User user = userDao.readUser(conn, id);
			if (user == null) {
				return false;
			}
			Date lastPasswordChange = user.getLast_password_change();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, -3);
			java.util.Date threeMonthsAgoUtil = calendar.getTime();
			Date threeMonthsAgo = new Date(threeMonthsAgoUtil.getTime());

			return lastPasswordChange.before(threeMonthsAgo);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
