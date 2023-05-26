package web.mvc.service.board;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.BoardListPage;
import web.mvc.domain.PageOptions;
import web.mvc.domain.TblBoard;

import java.util.List;

@Mapper
public interface BoardListService {

    // 게시글 리스트 로직 service
    List<TblBoard> listBoard();

}
