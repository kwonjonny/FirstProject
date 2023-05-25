package web.mvc.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TblBoard {
    private int bno;
    private String title;
    private String content;
    private Date regdate;
    private Date updatedate;
    private String user_id;
}
