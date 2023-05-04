package domain;

import java.sql.Date;

public class User {

	private String username;
	private String email;
	private String id;
	private String password;
	private int passwordChangeInterval;
	private Date last_password_change;
	
	private String verificationCode = "";
	private boolean isVerified;
	
	

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public User(String username, String email, String id, String password, int passwordChangeInterval,
			Date last_password_change) {
		super();
		this.username = username;
		this.email = email;
		this.id = id;
		this.password = password;
		this.passwordChangeInterval = passwordChangeInterval;
		this.last_password_change = last_password_change;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPasswordChangeInterval() {
		return passwordChangeInterval;
	}
	public void setPasswordChangeInterval(int passwordChangeInterval) {
		this.passwordChangeInterval = passwordChangeInterval;
	}
	public Date getLast_password_change() {
		return last_password_change;
	}
	public void setLast_password_change(Date last_password_change) {
		this.last_password_change = last_password_change;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", id=" + id + ", password=" + password
				+ ", passwordChangeInterval=" + passwordChangeInterval + ", last_password_change="
				+ last_password_change + "]";
	}
	
	
	

}
