package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.TblBoard;
import web.mvc.repository.board.BoardRepository;

@Service
public class BoardCreateServiceImpl implements BoardCreateService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;

    // BoardRepository interface 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardCreateServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 생성 로직 service
    @Override
    @Transactional
    public void createBoard(TblBoard tblBoard) {
        boardRepository.createBoard(tblBoard);
    }
}
