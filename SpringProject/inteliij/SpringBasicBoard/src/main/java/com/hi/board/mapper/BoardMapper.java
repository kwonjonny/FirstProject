package com.hi.board.mapper;


import com.hi.board.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectList(int startNum, int count);
    // selectList(0,5) #{param1} => 0, #{param2} => 5

    int selectTotalCount(BoardSearchOption boardSearchOption);

    int insertBoard(RequestRegBoard requestRegBoard);

    List<BoardDTO> selectAll();

    BoardDTO selectByBno(int bno);

    int updateBoard(RequestModifyRequest modifyRequest);

    int deleteBoard(int bno);



    List<BoardDTO> selectList(PageOption option);



}
