package web.mvc.service.board;

import web.mvc.domain.TblBoard;

public interface BoardReadService {

    // BoardRead service
    TblBoard selectByBno(int bno) throws Exception;

}
