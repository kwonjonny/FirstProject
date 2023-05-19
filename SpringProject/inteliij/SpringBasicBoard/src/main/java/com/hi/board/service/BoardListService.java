package com.hi.board.service;

import com.hi.board.domain.BoardDTO;
import com.hi.board.domain.BoardListPage;
import com.hi.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardListService {

    public final BoardMapper boardMapper;

    // page 개수 제한
    private final int countPerPage = 5;

    @Autowired
    public BoardListService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Transactional
    public List<BoardDTO> getBoardList() {
        return boardMapper.selectAll();
    }

    public BoardListPage getPage(int pageNum) {
        //  현재 요청 페이지
        int requestPageNum = pageNum;
        // 요청 페이지의 리스트 항목 : List<BoardDTO>
        List<BoardDTO> list = boardMapper.selectList((requestPageNum -1)*countPerPage, countPerPage);
        int totalCount = boardMapper.selectTotalCount();

        BoardListPage page = new BoardListPage(
                countPerPage, requestPageNum, list, totalCount);

        return page;
    }
}






