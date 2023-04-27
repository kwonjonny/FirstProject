package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import DBUtil.DBUtil;

public class UserDAO {
   
	UserDAO dao;
	
    public UserDAO()  {
        this.dao = UserDAO.getInstance();
    }
    
    private static UserDAO DAO = new UserDAO();
    
    public static UserDAO getInstance() {
    	return DAO;
    }

    public boolean insert(User user) {
    	Connection conn = null;
        String sql = "INSERT INTO users (username, email, id, password) VALUES (?, ?, ?, ?)";
        try {
        	conn= DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getId());
            pstmt.setString(4, user.getPassword());
            int result = pstmt.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByIdAndPassword(String id, String password) {
    	Connection conn = null;
        String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
        try {
        	conn= DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("email"), rs.getString("id"), rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findByUsername(String username) {
    	Connection conn = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
        	conn= DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("email"), rs.getString("id"), rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

