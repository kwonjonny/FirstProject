package web.mvc.repository.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.TblBoard;

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
    public List<TblBoard> readBoard(Map<String, String> parameters) {
        return sqlSession.selectList("web.mvc.repository.board.BoardRepository.readBoard", parameters);
    }

    // 게시글 업데이트 로직
    @Override
    public void updateBoard(TblBoard tblBoard) {
        sqlSession.update("web.mvc.repository.board.BoardRepository.updateBoard", tblBoard);
    }

    // 게시글 삭제 로직
    @Override
    public void deleteBoard(Map<String, Object> parameters) {
        sqlSession.delete("web.mvc.repository.board.BoardRepository.deleteBoard", parameters);
    }

    // 게시글 리스트 로직
    @Override
    public List<TblBoard> listBoard() {
        return sqlSession.selectList("web.mvc.repository.board.BoardRepository.listBoard");
    }
}
