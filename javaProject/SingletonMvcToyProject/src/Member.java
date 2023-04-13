
//Member 클래스 정의
//MemberRepository 인터페이스 정의
//MemberRepositoryImpl 클래스 정의
//MemberService 인터페이스 정의
//MemberServiceImpl 클래스 정의
//MemberController 클래스 정의
//Main 메소드 정의

public class Member {
	private int id;
	private String name;

	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
