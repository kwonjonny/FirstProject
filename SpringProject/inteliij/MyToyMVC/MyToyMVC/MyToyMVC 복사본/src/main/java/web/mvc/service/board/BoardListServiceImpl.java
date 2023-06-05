package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.BoardListPage;
import web.mvc.domain.PageOption;
import web.mvc.domain.TblBoard;
import web.mvc.domain.page.BoardSearchOption;
import web.mvc.repository.board.BoardRepository;

import java.util.List;

@Service
public class BoardListServiceImpl implements BoardListService {

    private final BoardRepository boardRepository;
    private final int countPerPage = 2;

    @Autowired
    public BoardListServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // BoardList service
    @Override
    @Transactional
    public List<TblBoard> getBoardList() throws Exception {
        return boardRepository.selectAll();
    }

    // BoardPaging service
    @Override
    @Transactional
    public BoardListPage getPage(int pageNum, BoardSearchOption searchOption) throws Exception {
        // 현재 요청 페이지
        int requestPageNum = pageNum;

        PageOption pageOption = PageOption.builder()
                .boardSearchOption(searchOption)
                .startNumber((requestPageNum-1)*countPerPage)
                .count(countPerPage)
                .build();
;
        List<TblBoard> list = boardRepository.selectList(pageOption);
        int totalCount = boardRepository.selectTotalCount(searchOption);
        // 전체 게시글 개수 -> 전체 페이지의 개수

        BoardListPage page = new BoardListPage(
                countPerPage,
                requestPageNum,
                list,
                totalCount
        );
        return page;
    }
}
