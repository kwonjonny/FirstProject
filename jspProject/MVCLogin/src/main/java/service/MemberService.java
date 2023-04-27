package service;

import java.util.List;

public interface MemberService {
	public List<MemberVo> list();

	public void register(MemberVo memberVo);

	public void remove(String id);

	public MemberVo login(String id, String pwd);

}
