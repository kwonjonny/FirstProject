package web.mvc.service.board;

import java.util.Map;

public interface BoardDeleteService {

    // 게시글 삭제 로직 service
    void deleteBoard(Map<String, Object> parameters);
}
