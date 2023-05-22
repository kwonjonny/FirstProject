package web.mvc.service.board;

import web.mvc.domain.TblBoard;

public interface BoardCreateService {

    // 게시글 생성 로직 service
    void createBoard(TblBoard tblBoard);
}
