package com.hi.board.service.member;

import com.hi.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberIdCheckService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberIdCheckService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public String idCheck(String uid){
        int result = memberMapper.selectCountByUid(uid);

        String checkResult = "N";
        if(result <1) {
            checkResult = "Y";
        }
        return checkResult;
    }

}
