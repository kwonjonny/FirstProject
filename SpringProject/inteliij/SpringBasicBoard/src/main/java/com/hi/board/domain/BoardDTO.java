package com.hi.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class BoardDTO {

    private int bno;
    private String title;
    private String content;
    private String writer;

    // 업로드한 파일의 이름
    private String regdate;
    private String updatedate;

    private String file1;
}
