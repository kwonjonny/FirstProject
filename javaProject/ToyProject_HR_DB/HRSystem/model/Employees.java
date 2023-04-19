package model;

public class Employees {

	// Employee TABLE -> 인스턴스 변수 정의
	private String employee_id; // 직원_id --> PRIMARY KEY 
	private String name; // 직원_이름
	private String email; // 직원_email
	private String phone_number; // 직원_number
	private String hiredate; // 직원_고용_날짜

	// 생성자 정의
	public Employees(String employee_id, String name, String email, String phone_number, String hiredate) {
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.hiredate = hiredate;
	}

	// Getter Setter 정의
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
