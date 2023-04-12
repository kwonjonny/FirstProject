

// 회원 Crud interface 
public interface MemberCrud {

	// 로그인
	public void login();

	// 로그아웃
	public void logout();

	// 회원 정보 생성
	public void createMember();

	// 회원 정보 삭제
	public void deleteMember();

	// 회원 정보 수정
	public void modifyMember();

	// 회원 정보 출력
	public void showDataMember();
}