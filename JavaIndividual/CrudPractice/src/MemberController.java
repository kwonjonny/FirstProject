import java.util.ArrayList;

// MemberController 클래스 정의 
public class MemberController implements CrudImpl {

	// 인스턴스 선언 
	private static MemberController instance;
	private ArrayList<Member> member;
	
	private MemberController() {
		member = new ArrayList<>();
	}
	
	public ArrayList<Member> getMembers() {
		return member;
	}
	
	public static MemberController getInstance() {
		if(instance == null) {
			instance = new MemberController();
		}
		return instance;
	}

	@Override
	public void create() {
	}

	@Override
	public void read() {
	}

	@Override
	public void update() {
	}

	@Override
	public void delete() {
	}
	
	
}
