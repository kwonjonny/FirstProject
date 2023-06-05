package web.mvc.service.board;

import org.springframework.web.multipart.MultipartFile;
import web.mvc.domain.TblBoard;

public interface BoardCreateService {

    // BoardCreate service
    void createBoard(TblBoard tblBoard) throws Exception;
}
