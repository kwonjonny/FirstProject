package web.mvc.repository.board;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.TblBoard;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardRepository {

    // 게시글 생성 로직
    void createBoard(TblBoard tblBoard);

    // 게시글 찾기 로직
    List<TblBoard> readBoard(Map<String, String> parameters);

    // 게시글 업데이트 로직
    void updateBoard(TblBoard tblBoard);

    // 게시글 삭제 로직
    void deleteBoard(Map<String, Object> parameters);

    // 게시글 리스트 로직
    List<TblBoard> listBoard();
}
