package web.mvc.repository.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.TblBoard;
import web.mvc.domain.TblBoardUpdateBoardDTO;
import web.mvc.domain.page.PageOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    // ByBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 게시글 생성 로직
    @Override
    public void createBoard(TblBoard tblBoard) {
        sqlSession.insert("web.mvc.repository.board.BoardRepository.createBoard", tblBoard);
    }

    // 게시글 찾기 로직
    @Override
    public List<TblBoard> selectList(PageOption pageOption) {
        return sqlSession.selectList("web.mvc.repository.board.BoardRepository.selectList", pageOption);
    }


    // 게시글 업데이트 로직
    @Override
    public void updateBoard(TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO) {
        sqlSession.update("web.mvc.repository.board.BoardRepository.updateBoard", tblBoardUpdateBoardDTO);
    }

    // 게시글 삭제 로직
    @Override
    public void deleteBoard(String user_id , int bno) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        parameters.put("bno", bno);
        sqlSession.delete("web.mvc.repository.board.BoardRepository.deleteBoard", parameters);
    }

    // 게시글 리스트 로직
    @Override
    public List<TblBoard> listBoard() {
        return sqlSession.selectList("web.mvc.repository.board.BoardRepository.listBoard");
    }

    // 게시글 업데이트 리스트 로직
    @Override
    public TblBoard updateListBoard(String user_id, int bno) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", user_id);
        parameters.put("bno", bno);
        return sqlSession.selectOne("web.mvc.repository.board.BoardRepository.updateListBoard",parameters);
    }
}
