import java.util.ArrayList;

// 비회원 Controller 
public class NoMemberController {

	private static NoMemberController instance;
	private ArrayList<NoMember> noMember;

	private NoMemberController() {
		noMember = new ArrayList<>();
	}

	public ArrayList<NoMember> getNoMembers() {
		return noMember;
	}

	public static NoMemberController getInstance() {
		if (instance == null) {
			instance = new NoMemberController();
		}
		return instance;
	}
}
