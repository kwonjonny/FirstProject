package web.mvc.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import web.mvc.domain.TblBoard;
import web.mvc.repository.board.BoardRepository;
import web.mvc.repository.board.BoardRepositoryImpl;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.UUID;

@Service
public class BoardCreateServiceImpl implements BoardCreateService {

    // BoardRepository interface 인스턴스 변수 정의
    private final BoardRepository boardRepository;
    private final ServletContext servletContext;

    // BoardRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardCreateServiceImpl(BoardRepositoryImpl boardRepository, ServletContext servletContext) {
        this.boardRepository = boardRepository;
        this.servletContext = servletContext;
    }

    // BoardCreate service
    @Override
    @Transactional
    public void createBoard(TblBoard tblBoard) throws Exception {
//        if(tblBoard.getFile() != null && tblBoard.getFile().getSize()>0) {
//            // 웹 경로
//            String uri = servletContext.getRealPath("/uploadfile/board");
//
//            // 새로운 파일 이름 생성 : 중복된 이미지 이름을 중복되지 않게 난수
//            String newFilename = UUID.randomUUID().toString()+tblBoard.getFile().getOriginalFilename();
//
//            File newFile = new File(uri, newFilename);
//
//            // 파일 저장
//            file.transferTo(newFile);
//
//            // 새로운 파일 이름 저장
//            tblBoard.setFilename(newFilename);
//        }

        boardRepository.createBoard(tblBoard);
    }
}
