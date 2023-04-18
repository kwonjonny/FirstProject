
// 관리자 클래스 
public class Admin {
	// 인스턴스 변수 정의
	private String adminId;
	private String adminPassword;

	// 생성자 정의
	public Admin(String adminId, String adminPassword) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	// Getter Setter
	public String getAdminId() {
		return adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}