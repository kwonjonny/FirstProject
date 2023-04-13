import java.util.List;

interface MemberRepository {
	
	void create(Member member);

	Member read(String id);

	void update(Member member);

	void delete(String id);

	List<Member> findAll();

}