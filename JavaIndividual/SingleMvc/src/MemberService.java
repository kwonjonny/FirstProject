import java.util.List;

public interface MemberService {
	void join(Member member);

	Member findMember(String id, String password);

	void updateMember(Member member);

	void removeMember(String id);

	List<Member> getMemberList();
}
