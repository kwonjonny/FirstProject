import java.util.List;

// MemberService는 비즈니스 로직을 추상화한 
// 인터페이스 
// MemberService는 MemberRepository 를 사용 
// 하여 비즈니스 로직을 처리하여 그 결과를 컨트롤러에 반환하는 역할 
public interface MemberService {
	void addMember(Member member);

	void removeMember(Member member);

	List<Member> getMembers();

	Member getMemberById(int id);
}
