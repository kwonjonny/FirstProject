package com.hi.board.service.member;

import com.hi.board.domain.member.MemberDTO;
import com.hi.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberLoginService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberLoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public boolean login(String uid, String pw, HttpSession session) {
        // uid, pw, selectByUidPw(uid, pw) => null or MemberDTO

        MemberDTO member = memberMapper.selectByUidPw(uid, pw);
        if(member != null) {
            // user 이다 로그인 처리를 해준다
            session.setAttribute("loginInfo", member);

            // interceptor 에서 -> session 의 속성에 loginInfo 값의 유무에 따라 로그인 체크


            return true;
        }

        return false;
    }
}
