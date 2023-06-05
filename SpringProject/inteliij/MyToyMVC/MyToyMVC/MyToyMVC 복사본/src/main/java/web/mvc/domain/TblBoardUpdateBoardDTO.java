package web.mvc.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

// user lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TblBoardUpdateBoardDTO {
    private int bno;
    private String title;
    private String content;
    private String user_id;

    // file upload 를 위한 변수
    private MultipartFile file;
    // file DB에 들어가는 filename
    private String filename;
}
