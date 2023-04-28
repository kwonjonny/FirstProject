package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import domain.User;
import util.DBConnection;

public class UserService {

	// UserDao dao 인스턴스 생성
	private UserDao dao;

	private static UserService service = new UserService();

	// UserDao 의 인스턴스 가져옴
	public UserService() {
		this.dao = UserDao.getInstance();
	}

	public static UserService getInstance() {
		return service;
	}

	// 유저 로그인
	public User login(String id, String password) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			user = dao.findLogin(conn, id, password);
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	// 유저 리스트
	public List<User> getUserList() {
		Connection conn = null;
		List<User> list = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			list = dao.getUserList(conn);
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public int createUser(User user) {
		Connection conn = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			result = dao.createUser(conn, user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 유저 검색
	public User readUser(String id) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			user = dao.readUser(conn, id);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	// 유저 업데이트
	public int updateUser(User user) {
		Connection conn = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			result = dao.update(conn, user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 유저 삭제
	public int deleteUser(String id) {
		Connection conn = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			result = dao.deleteUser(conn, id);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
