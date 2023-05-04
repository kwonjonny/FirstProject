package service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.user.UserDao;
import domain.User;
import service.email.EmailServiceCreateUser;
import service.email.EmailServiceDeleteUser;
import service.email.EmailServiceForgotPassword;
import service.email.EmailServiceVerifyCode;
import util.DB.DBConnection;

public class UserService {

	// UserDao dao 인스턴스 생성
	private UserDao dao;

	// singleton pattern
	private static UserService service = new UserService();

	// UserDao 의 인스턴스 가져옴
	public UserService() {
		this.dao = UserDao.getInstance();
	}

	// controller에서 필요한 getInstance 생성
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

//	// 유저 회원가입
//	public int createUser(User user) {
//		Connection conn = null;
//		int result = 0;
//		try {
//			conn = DBConnection.getConnection();
//			conn.setAutoCommit(false);
//			result = dao.createUser(conn, user);
//			conn.commit();
//			// 유저 생성 후 이메일 발송
//			EmailServiceCreateUser.getInstance().sendEmailCreateUser(user);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}

	// 인증 이메일 발송 로직
	public int EmailVerifyCode(User user) {
		Connection conn = null;
		int authCode = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			authCode = EmailServiceVerifyCode.getInstance().sendEmailVerifyCode(user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return authCode;
	}

	// 로그인 3개월 password 변경 테스트용 createUser 로직
	public int createTestUser(User user) {
		int result = 0;
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			result = dao.createTestUser(conn, user);
			EmailServiceCreateUser.getInstance().sendEmailCreateUser(user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
			result = dao.updateUser(conn, user);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
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
			User user = dao.readUser(conn, id);
			result = dao.deleteUser(conn, id);
			conn.commit();
			// 삭제 후 이메일 발송
			EmailServiceDeleteUser.getInsatnce().sendEmailDeleteUser(user);
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

	// 이메일 보내기
	public User sendEmail(String email) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			// 이메일 보내기 전 해당 이메일 가입 유저가 있는지 확인
			user = dao.findByEmail(conn, email);
			conn.commit();
			// 이메일 발송
			EmailServiceForgotPassword.getInstance().sendEmail(user);
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
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

	public User findUserByEmail(String email) {
		User result = null;
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			result = dao.findByEmail(conn, email); // findByEmail 메소드를 사용하여 사용자 찾기
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
