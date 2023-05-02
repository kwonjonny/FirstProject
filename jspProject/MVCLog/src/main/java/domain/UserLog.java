package domain;

import java.sql.Timestamp;

public class UserLog {

	private int id;
	private String userId;
	private Timestamp timestamp;
	public UserLog(int id, String userId, Timestamp timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.timestamp = timestamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
