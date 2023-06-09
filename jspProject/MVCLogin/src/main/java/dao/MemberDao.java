package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVo;
import utils.DBConn;

public class MemberDao {
	/**
	 * singleton
	 */
	private final static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public MemberDao() {
	}

	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection conn;

	// list, register, remove 생략

	public MemberVo login(String id, String pwd) {
		MemberVo memberVo = null;

		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER WHERE ID = ? AND PWD = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = 1;
				memberVo = new MemberVo(rs.getString(idx++), rs.getString(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getDate(idx++));
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberVo;
	}
}
