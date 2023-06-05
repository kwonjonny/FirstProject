package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.repository.board.BoardRepository;

@Service
public class BoardDeleteServiceImpl implements BoardDeleteService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;

    // BoardRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardDeleteServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // BoardDelete service
    @Override
    @Transactional
    public void deleteBoard(String user_id, int bno) throws Exception {
        boardRepository.deleteBoard(user_id, bno);
    }
}
