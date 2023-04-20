package domain;

import java.time.LocalDate;

public class EmployeeJobJobHistory {
	
	// EMPLOYEES TABLE -> 인스턴스 변수 정의
	private String employee_id; // 직원_id --> PRIMARY KEY
	private String name; // 직원_이름
	private String email; // 직원_email
	private String phone_number; // 직원_number
	private String hiredate; // 직원_고용_날짜
	
	// JOBS TABLE -> 인스턴스 변수 정의
	private String jobs_id; // 직업_id --> PRIMARY KEY
	private String jobs_title; // 직업_직함
	private String jobs_description; // 직업_설명
	private int salary; // 연봉
	
	// JOB_HISTORY TABLE -> 인스턴스 변수 정의
	private LocalDate start_date; // 시작 날짜
	private LocalDate end_date; // 퇴사 날짜
	
	public EmployeeJobJobHistory(String employee_id, String name, String email, String phone_number, String hiredate,
			String jobs_id, String jobs_title, String jobs_description, int salary, LocalDate start_date,
			LocalDate end_date) {
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.hiredate = hiredate;
		this.jobs_id = jobs_id;
		this.jobs_title = jobs_title;
		this.jobs_description = jobs_description;
		this.salary = salary;
		this.start_date = start_date;
		this.end_date = end_date;
	}

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

	public String getJobs_id() {
		return jobs_id;
	}

	public void setJobs_id(String jobs_id) {
		this.jobs_id = jobs_id;
	}

	public String getJobs_title() {
		return jobs_title;
	}

	public void setJobs_title(String jobs_title) {
		this.jobs_title = jobs_title;
	}

	public String getJobs_description() {
		return jobs_description;
	}

	public void setJobs_description(String jobs_description) {
		this.jobs_description = jobs_description;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
	    return "EmployeeJobJobHistory{" +
	            "employee_id='" + employee_id + '\'' +
	            ", name='" + name + '\'' +
	            ", email='" + email + '\'' +
	            ", phone_number='" + phone_number + '\'' +
	            ", hiredate='" + hiredate + '\'' +
	            ", jobs_id='" + jobs_id + '\'' +
	            ", jobs_title='" + jobs_title + '\'' +
	            ", jobs_description='" + jobs_description + '\'' +
	            ", salary=" + salary +
	            ", start_date=" + start_date +
	            ", end_date=" + end_date +
	            '}';
	}
	
}
