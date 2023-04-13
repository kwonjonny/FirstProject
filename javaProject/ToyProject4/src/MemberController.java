import java.util.List;


// MemberController 는 클라이언트 요청을 받아 
// MemberServcie를 통해 회원정보 추가 삭제 조회의 역할을 한다 
// MeberServcie 인터페이스를 구현한 구현체(MemberServcieImpl) 를 
// 멤버 변수로 가지고 있다 
// 이 멤버변수를 통해 실제로 MemberServcie의 메소드를 호출 
public class MemberController {
	
    private MemberService memberService;

    // MemberService 객체를 인자로 받아서 멤버 변수 memberService에 저장합니다. 
    // 이후 MemberController 클래스 
    // 내부의 다른 메소드들에서 이 객체를 사용하여 MemberService의 메소드를 호출합니다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // addMember() 메소드는 클라이언트로부터 받은 회원정보를 Member 객체로 만든 뒤, 
    // MemberService의 addMember() 메소드를 호출하여 회원을 추가합니다.
    public void addMember(int id, String name) {
        Member member = new Member(id, name);
        memberService.addMember(member);
    }
    
    // removeMember() 메소드는 클라이언트로부터 받은 회원 id로 해당 회원을 조회한 뒤, 
    //MemberService의 removeMember() 메소드를 호출하여 회원을 삭제합니다.
    public void removeMember(int id) {
        Member member = memberService.getMemberById(id);
        if (member != null) {
            memberService.removeMember(member);
        }
    }

    // getMembers() 메소드는 MemberService의 getMembers() 메소드를 호출하여 모든 회원 정보를 조회한 후, 
    // List<Member> 타입으로 반환합니다.
    public List<Member> getMembers() {
        return memberService.getMembers();
    }
}
