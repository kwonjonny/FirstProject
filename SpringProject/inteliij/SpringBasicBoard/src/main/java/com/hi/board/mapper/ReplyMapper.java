package com.hi.board.mapper;

import com.hi.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface ReplyMapper {

    @Select("select * from tbl_reply where rno = #{rno}")
    ReplyDTO selectByBno(int rno);


    // insert
    @Insert("insert into tbl_reply (bno, reply, memIdx) values (#{bno} , #{reply}, #{memIdx})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
    int insertReply(ReplyDTO reply);

}
