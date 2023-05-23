package web.mvc.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TblBoardUpdateBoardDTO {
    private int bno;
    private String title;
    private String content;
    private Date updatedate;
    private String user_id;
}
