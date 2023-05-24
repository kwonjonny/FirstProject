package web.mvc.service.board;

import web.mvc.domain.TblBoard;

public interface BoardContentService {

    // 게시물 보기 로직 service
    TblBoard boardContent(int bno);

}
