package com.hi.board.mapper;


import com.hi.board.domain.BoardDTO;
import com.hi.board.domain.RequestRegBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int insertBoard(RequestRegBoard requestRegBoard);

    List<BoardDTO> selectAll();

}
