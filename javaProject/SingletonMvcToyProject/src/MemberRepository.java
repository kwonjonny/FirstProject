import java.util.List;


// MemberRepository 는 데이터베이스와의 
// 연동을 추상화한 인터페이스
// MemberRepoistroy 는 Member객체를 데이터베이스에 저장하거나
// 수정 , 삭제하는 기능을 제공 
public interface MemberRepository {
	void insert(Member member);

	void delete(Member member);

	Member selectById(int id);

	List<Member> selectAll();
}
