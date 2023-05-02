package todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.domain.RequestTodo;
import todo.domain.TodoDTO;
import todo.util.DBConnection;

public class TodoDAO {

	// 싱글톤
	// 1. 생성자 - private
	private TodoDAO() {
	}

	// 2. 내부에서 todoDAO 인스턴스 생성 -> private static
	private static TodoDAO dao = new TodoDAO();

	// 3. 외부에서 요청에 대한 처리는 TodoDAO의 참조값을 얻어갈 수 있는 메소드 -> public static
	public static TodoDAO getInsatnce() {
		return dao;
	}

	// rs - > TodoDTO 생성 => 반환하는 메소드
	private TodoDTO makeTodoDTO(ResultSet rs) throws SQLException {
		return new TodoDTO(rs.getInt("tno"), rs.getString("todo"), rs.getString("duedate"), rs.getBoolean("finished"));
	}

	// TodoDTO 리스트를 반환하는 메소드
	public List<TodoDTO> selectByAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TodoDTO> List = null;
		try {
			// query / sql
			String query = "select * from tbl_todo";
			// PreparedStatement
			ps = conn.prepareStatement(query);
			// 결과 받기
			rs = ps.executeQuery();
			List = new ArrayList<TodoDTO>();
			while (rs.next()) {
//				int tno = rs.getInt("tno");
//				String todo = rs.getString("todo");
//				String duedate = rs.getString("duedate");
//				boolean finished = rs.getBoolean("finished");
//
//				TodoDTO dto = new TodoDTO(tno, todo, duedate, finished);
				List.add(makeTodoDTO(rs));
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
		return List;
	}

	// tno 값을 받아서 해당 Todo 정보 (TodoDTO) 를 반환하는 메소드
	public TodoDTO selectByTno(Connection conn, int tno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		TodoDTO todo = null;
		try {
			String query = "select * from tbl_todo where tno=?";
			ps = conn.prepareStatement(query);
			// set
			ps.setInt(1, tno);
			// rs
			rs = ps.executeQuery();
			// if : 결과 행 이 0 또는 1일 때
			if (rs.next()) {
//				todo = new TodoDTO(rs.getInt("tno"), rs.getString("todo"), rs.getString("duedate"),
//						rs.getBoolean("finished"));
				todo = makeTodoDTO(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return todo;
	}

	// RequestTodo 데이터를 받아서 insert 처리
	public int insertTodo(Connection conn, RequestTodo todo) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "INSERT INTO tbl_todo (todo,duedate) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, todo.getTodo());
			ps.setString(2, todo.getDuedate());
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

	// TodoDTO 전달 받고
	// update
	public int updateByTno(Connection conn, TodoDTO todo) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "UPDATE tbl_todo SET todo =?, duedate=?, finished=? WHERE tno =?";
			ps = conn.prepareStatement(query);
			// set
			ps.setString(1, todo.getTodo());
			ps.setString(2, todo.getDuedate());
			ps.setBoolean(3, todo.isFinished());
			ps.setInt(4, todo.getTno());
			// result
			ps.executeUpdate();
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

	// tno 전달받고
	// delete
	public int deleteByTno(Connection conn, int tno) {
		PreparedStatement ps = null;
		int result = 0;
		try {
			String query = "delete from tbl_todo where tno=?";
			ps = conn.prepareStatement(query);
			// set
			ps.setInt(1, tno);
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

	public static void main(String[] args) throws SQLException {
		TodoDAO dao = TodoDAO.getInsatnce();
		Connection conn = DBConnection.getConnection();

		// list test
//		List<TodoDTO> List = dao.selectByAll(conn);
//		for (TodoDTO todo : List) {
//			System.out.println(todo);

		// insert test
//		dao.insertTodo(conn, new RequestTodo("회의", "2023-05-05"));
//		System.out.println("입력완료");

		// seelctByTno test
//		TodoDTO todo = dao.selectByTno(conn, 2);
//		System.out.println(todo);

		// update test
//		dao.updateByTno(conn, new TodoDTO(2,"청소 후 휴식","2023-05-03",true));
//		System.out.println("update shoot the Trill!");

		// delete test
//		dao.deleteByTno(conn, 2);
//		System.out.println("delete fire!");

		conn.close();
	}

}
