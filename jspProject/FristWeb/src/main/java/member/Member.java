package member;


// Java Beans 의 형태 : 모든 변수는 private, getter 와 setter 가 정의 되어야한다 
// 기본생성자도 정의 
// 필요에 따라 toString  
public class Member {

	// 인스턴스 변수 정의 
	private String id;
	private String password; 
	private String name;
	
	//  생성자 정의 
	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	// default 생성자 정의 
	public Member() {
		
	}

	// Getter Setter 정의 
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return this.id + "(" + this.name + ")";
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + "]";
	}

}
