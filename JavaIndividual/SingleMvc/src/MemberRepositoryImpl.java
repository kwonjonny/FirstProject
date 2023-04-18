
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {
	
	// MemberRepositoryImpl 클래스는 
	// 실제로 Member 객체를 저장하고 관리하는 역할을 하며
	// 따라서 MemberService에서는 MemberRepository 인터페이스의 
	// 메소드들을 호출하여 Member 객체를 CRUD(create, read, update, delete)하는데 사용
	private static MemberRepositoryImpl instance;
	private List<Member> members;

	private MemberRepositoryImpl() {
		members = new ArrayList<>();
	}

	public static MemberRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new MemberRepositoryImpl();
		}
		return instance;
	}

	@Override
	public void create(Member member) {
		members.add(member);
	}

	@Override
	public Member read(String id) {
		for (Member member : members) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	@Override
	public void update(Member member) {
		Member target = read(member.getId());
		if (target != null) {
			target.setName(member.getName());
		}
	}

	@Override
	public void delete(String id) {
		Member target = read(id);
		if (target != null) {
			members.remove(target);
		}
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(members);
	}
	
}