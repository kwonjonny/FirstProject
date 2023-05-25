package web.mvc.service.board;

import web.mvc.domain.TblBoard;

public interface BoardUpdateListBoardService {

    // Board update 로직 service
    TblBoard updateListBoard(String user_id, int bno);

}
