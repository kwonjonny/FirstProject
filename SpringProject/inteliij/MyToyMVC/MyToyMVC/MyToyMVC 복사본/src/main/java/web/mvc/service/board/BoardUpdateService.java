package web.mvc.service.board;

import web.mvc.domain.TblBoard;
import web.mvc.domain.TblBoardUpdateBoardDTO;

public interface BoardUpdateService {

    // 게시글 업데이트 로직 service
    void updateBoard(TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO);

}
