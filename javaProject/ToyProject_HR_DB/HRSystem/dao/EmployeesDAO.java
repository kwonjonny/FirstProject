package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Employees;

public class EmployeesDAO {
	// 인스턴스 변수 정의
    // singleton pattern
    private static EmployeesDAO instance;
    private Connection conn;

    public EmployeesDAO(Connection conn) {
        this.conn = conn;
    }

    // EmployeesDAO 클래스의 인스턴스가 한 번만 생성되며 생성된 인스턴스에서는 DBConnection 클래스의
    // 인스턴스를 사용하여 Connection 객체를 얻어올 수 있다
    public static EmployeesDAO getInstance(Connection conn) {
        if (instance == null) {
            instance = new EmployeesDAO(conn);
        } else {
            instance.conn = conn;
        }
        return instance;
    }

	// SQL Employee create
	public void create(Employees employees) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO EMPLOYEES(employee_id, name, email, phone_number, hiredate) VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, employees.getEmployee_id());
			ps.setString(2, employees.getName());
			ps.setString(3, employees.getEmail());
			ps.setString(4, employees.getPhone_number());
			ps.setString(5, employees.getHiredate());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL Employee read
	public Employees read(String name) throws SQLException {
		Employees employees = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("NO reocord found for " + name);
			}
			employees = new Employees(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
					rs.getString("phone_number"), rs.getString("hiredate"));
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return employees;
	}

	// SQL Employee update
	public Employees update(String name, Employees newEmployees) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No record found for " + name);
			}

			String queryUpdate = "UPDATE EMPLOYEES SET employee_id = ?, name = ?, email = ?, phone_number = ?, hiredate = ? WHERE name = ?";
			ps = conn.prepareStatement(queryUpdate);
			ps.setString(1, newEmployees.getEmployee_id());
			ps.setString(2, newEmployees.getName());
			ps.setString(3, newEmployees.getEmail());
			ps.setString(4, newEmployees.getPhone_number());
			ps.setString(5, newEmployees.getHiredate());
			ps.setString(6, name);

			int updateRows = ps.executeUpdate();
			if (updateRows > 0) {
				return newEmployees;
			} else {
				return null;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL Employee delete
	public Employees delete(String name) throws SQLException {
		Employees employees = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No record found for " + name);
			}
			employees = new Employees(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
					rs.getString("phone_number"), rs.getString("hiredate"));

			String queryDelete = "DELETE FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(queryDelete);
			ps.setString(1, name);
			int deleteRows = ps.executeUpdate();
			if (deleteRows > 0) {
				return employees;
			} else {
				return null;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}
}