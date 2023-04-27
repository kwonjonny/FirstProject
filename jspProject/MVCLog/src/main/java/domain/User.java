package domain;

public class User {

	private String username;
	private String email;
	private String id;
	private String password;
	
	public User(String username, String email, String id, String password) {
		this.username = username;
		this.email = email;
		this.id = id;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", id=" + id + ", password=" + password + "]";
	}
	
}
