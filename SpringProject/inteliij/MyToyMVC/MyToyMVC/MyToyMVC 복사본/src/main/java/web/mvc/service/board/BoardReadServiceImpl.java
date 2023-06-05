package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.TblBoard;
import web.mvc.repository.board.BoardRepository;

@Service
public class BoardReadServiceImpl implements BoardReadService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;

    // BoardRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardReadServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // BoardRead service
    @Override
    @Transactional
    public TblBoard selectByBno(int bno) throws Exception {
        return boardRepository.selectByBno(bno);
    }
}
