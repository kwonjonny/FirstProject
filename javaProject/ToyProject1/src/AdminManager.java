

// Admin interface 
public interface AdminManager {
	// 관리자 로그인
	public void adminLogin();

	// 관리자 로그아웃
	public void adminLogout();

	// 관리자 회원 목록 조회
	public void memberShowData();

	// 관리자 회원 정보 수정
	public void memberModify();

	// 관리자 회원 삭제
	public void memberDelete();
}
