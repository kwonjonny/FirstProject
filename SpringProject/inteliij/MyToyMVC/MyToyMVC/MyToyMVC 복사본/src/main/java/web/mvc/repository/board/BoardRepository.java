package web.mvc.repository.board;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.PageOption;
import web.mvc.domain.TblBoard;
import web.mvc.domain.TblBoardUpdateBoardDTO;
import web.mvc.domain.page.BoardSearchOption;

import java.util.List;

@Mapper
public interface BoardRepository {


    // 게시글 찾기 로직
    List<TblBoard> selectList(PageOption pageOption) throws Exception;

    int selectTotalCount(BoardSearchOption searchOption) throws Exception;

    // 게시글 리스트 로직
    List<TblBoard> selectAll() throws Exception;

    // 제목 읽기
    TblBoard selectByBno(int bno) throws Exception;

    // 게시글 생성 로직
    void createBoard(TblBoard tblBoard) throws Exception;

    // 게시글 업데이트 로직
    void updateBoard(TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO) throws Exception;

    // 게시글 삭제 로직
    void deleteBoard(String user_id, int bno) throws Exception;

}
