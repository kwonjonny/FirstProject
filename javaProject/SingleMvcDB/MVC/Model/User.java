package Model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class User {

	// 인스턴스 변수 정의
	private String id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private int grade;
	private Date creatDate;
	private String role;

	// 생성자 정의
	public User(String id, String username, String password, String name, String email, String address, String phone,
			int grade, Date createDate, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.grade = grade;
		this.creatDate = createDate;
		this.role = role;
	}

	// Getter Setter정의
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
