package web.mvc.service.board;

import web.mvc.domain.BoardListPage;
import web.mvc.domain.TblBoard;
import web.mvc.domain.page.BoardSearchOption;

import java.util.List;

public interface BoardListService {

    // boardList service
    List<TblBoard> getBoardList() throws Exception;

    // BoardPaging service
    BoardListPage getPage(int pageNum, BoardSearchOption searchOption) throws Exception;
}
