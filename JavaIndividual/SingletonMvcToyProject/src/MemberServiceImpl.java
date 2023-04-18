import java.util.List;


// MemberServiceImpl은 MemberRepository를 구현한 구현체로써
// MemberRepositroy에서 정의된 메소드를 구현하고 
// 이를 실제로 사용하여 Member객체를 추가 삭제 조회 하는 기능 제공 
//MemberRepositoryImpl은 인터페이스로써 어떤 객체가 Member객체를 저장하고 
//조회하는 기능을 제공하는지에 대한 명세만을 제공 이를 실제로 구현한 객체는
//MemberServcieImpl클래스 

public class MemberServiceImpl implements MemberService {
	
	private MemberRepository memberRepository;

	// MemberServiceImpl 클래스의 생성자입니다. 생성자에서 MemberRepository 
	// 타입의 인자를 받아서 memberRepository 필드에 할당하는 역할을 합니다. 
	// 이를 통해 MemberServiceImpl 객체가 생성될 때, MemberRepository 
	// 구현체를 주입받아서 이를 사용할 수 있습니다. 이러한 방식을 "의존성 주입(Dependency Injection)"이라고 합니다. 
	// 이를 사용하면 유연하고 확장성 있는 코드를 작성할 수 있습니다.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// Member 객체를 매개변수로 받아 
	// MemberRepository의 insert() 메소드를 호출하여 Member 객체를 저장합니다.
	@Override
	public void addMember(Member member) {
		memberRepository.insert(member);
	}

	// Member 객체를 매개변수로 받아 
	// MemberRepository의 delete() 메소드를 호출하여 Member 객체를 삭제합니다
	@Override
	public void removeMember(Member member) {
		memberRepository.delete(member);
	}

	// id를 매개변수로 받아 MemberRepository의 selectById() 
	// 메소드를 호출하여 해당 id에 해당하는 Member 객체를 조회하여 반환합니다.
	@Override
	public Member getMemberById(int id) {
		return memberRepository.selectById(id);
	}

	// MemberRepository의 selectAll() 메소드를 
	// 호출하여 저장된 모든 Member 객체를 조회하여 List<Member> 형태로 반환합니다.
	@Override
	public List<Member> getMembers() {
		return memberRepository.selectAll();
	}
}
