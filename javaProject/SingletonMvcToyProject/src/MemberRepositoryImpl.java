import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MemberRepositoryImpl 은 
// Member 객체를 저장하고 조회하는 추상 메소드를 갖는 인터페이스
// MemberRepositoryImpl은 인터페이스로써 어떤 객체가 Member객체를 저장하고 
// 조회하는 기능을 제공하는지에 대한 명세만을 제공 이를 실제로 구현한 객체는
// MemberServcieImpl클래스 
public class MemberRepositoryImpl implements MemberRepository {
	
	// store는 Map 인터페이스를 구현한 HashMap 객체로, Member 객체를 저장하기 
	// 위한 변수입니다.
	// Integer 타입의 id 값을 키로 사용하고, Member 객체를 값으로 저장합니다.
	// sequence는 Member 객체에 할당될 id 값을 생성하기 위한 변수입니다. 
	// sequence 변수는 클래스 레벨에서 static으로 선언되었기 때문에, 
	// MemberRepositoryImpl 클래스의 인스턴스가 생성될 때마다 증가하는 것이 
	// 아니라 클래스 레벨에서 오직 하나만 존재하며, 모든 인스턴스에서 공유됩니다. 
	private Map<Integer, Member> store = new HashMap<>();
	private static int sequence = 0;

	
	// insert(Member member) : Member 객체를 저장하는 메소드입니다.
	// 이 메소드는 Member 객체를 매개변수로 받아, 
	// Member 객체의 id를 증가시킨 후, HashMap에 id와 Member 객체를 저장합니다.
	@Override
	public void insert(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
	}
	
	// delete(Member member) : Member 객체를 삭제하는 메소드입니다. 이 메소드는 
	// Member 객체를 매개변수로 받아, HashMap에서 해당 Member 객체를 삭제합니다.
	@Override
	public void delete(Member member) {
		store.remove(member.getId());
	}

	// selectById(int id) : id를 기준으로 Member 객체를 조회하는 메소드입니다.
	// 이 메소드는 
	// id를 매개변수로 받아, HashMap에서 해당 id를 가진 Member 객체를 반환합니다.
	@Override
	public Member selectById(int id) {
		return store.get(id);
	}

	// selectAll() : 저장된 모든 Member 객체를 조회하는 메소드입니다. 
	//이 메소드는 HashMap의 모든 Member 객체를 ArrayList로 변환한 뒤, 반환합니다.
	@Override
	public List<Member> selectAll() {
		return new ArrayList<>(store.values());
	}
}
