package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.repository.board.BoardRepository;

import java.util.Map;

@Service
public class BoardDeleteServiceImpl implements BoardDeleteService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;

    // BoardRepository interface 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardDeleteServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 삭제 로직 service
    @Override
    @Transactional
    public void deleteBoard(String user_id, int bno) {
        boardRepository.deleteBoard(user_id,bno);
    }
}
