import java.util.List;

public class MemberServiceImpl implements MemberService {

	
	// MemberServiceImpl은 MemberRepository 
	// 인터페이스를 구현한 MemberRepositoryImpl 
	// 클래스의 인스턴스를 생성해 의존성을 주입받고
	// MemberRepository의 메소드를 호출하여 필요한 Member 
	// 객체를 CRUD(create, read, update, delete)하는데 사용
	// 이를 통해 느슨한 결합을 구현하여 유지보수와 확장성을 높일 수 있습니다
	private MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.create(member);
	}

	@Override
	public Member findMember(String id, String password) {
		return memberRepository.read(id);
	}

	@Override
	public void updateMember(Member member) {
		memberRepository.update(member);
	}

	@Override
	public void removeMember(String id) {
		memberRepository.delete(id);
	}

	@Override
	public List<Member> getMemberList() {
		return memberRepository.findAll();
	}

}
