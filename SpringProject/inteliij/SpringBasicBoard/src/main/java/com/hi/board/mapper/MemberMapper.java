package com.hi.board.mapper;

import com.hi.board.domain.member.MemberRegistRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {


    int selectByUidPw(String uid, String pw);

    // insert
    int insertMember(MemberRegistRequest registRequest);

    // 회원 존재 여부 확인
    @Select("select count(*) from member where uid=#{}")
    int selectCountByUid(String uid);

}