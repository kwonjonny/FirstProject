package web.mvc.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TblBoard {
    private int bno;
    private String title;
    private String content;
    private String user_id;
    private Date regdate;
    private Date updatedate;
}
