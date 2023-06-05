package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.TblBoardUpdateBoardDTO;
import web.mvc.repository.board.BoardRepository;

@Service
public class BoardUpdateServiceImpl implements BoardUpdateService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;

    // BoarRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardUpdateServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // BoardUpdate service
    @Override
    @Transactional
    public void updateBoard(TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO) throws Exception {
        boardRepository.updateBoard(tblBoardUpdateBoardDTO);
    }
}