package web.mvc.service.board;

import web.mvc.domain.TblBoard;

import java.util.List;
import java.util.Map;

public interface BoardReadService {

    // 게시글 찾기 로직 service
    List<TblBoard> readBoard(Map<String, String> parameters);

}
