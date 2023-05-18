package com.hi.board.service;

import com.hi.board.domain.RequestRegBoard;
import com.hi.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class BoardWriteService {

    public final BoardMapper boardMapper;

    @Autowired
    public BoardWriteService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Transactional
    public int writeBoard(RequestRegBoard requestRegBoard) {
        return boardMapper.insertBoard(requestRegBoard);
    }
}
