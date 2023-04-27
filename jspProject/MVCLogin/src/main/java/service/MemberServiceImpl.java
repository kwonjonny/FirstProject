package service;
import java.util.List;

import member.dao.MemberDao;
import member.vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	private static final MemberService memberService = new MemberServiceImpl();
	public static MemberService getInstance() {
		return memberService;
	}
	private MemberServiceImpl() {}
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	// list, register, remove 생략
	
	@Override
	public MemberVo login(String id, String pwd) {
		return memberDao.login(id, pwd);
	}
}
