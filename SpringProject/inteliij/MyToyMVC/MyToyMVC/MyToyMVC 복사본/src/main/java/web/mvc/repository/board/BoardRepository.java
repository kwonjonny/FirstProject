package web.mvc.repository.board;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.TblBoard;
import web.mvc.domain.page.PageOption;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardRepository {

    // 게시글 생성 로직
    void createBoard(TblBoard tblBoard);

    // 게시글 찾기 로직
    List<TblBoard> selectList(PageOption pageOption);

    // 게시글 업데이트 로직
    void updateBoard(TblBoard tblBoard);

    // 게시글 리스트 로직
    List<TblBoard> listBoard();

    // 게시글 삭제 로직
    void deleteBoard(String user_id, int bno);

    // 게시글 업데이트 리스트 로직
    TblBoard updateListBoard(String user_id, int bno);
}
