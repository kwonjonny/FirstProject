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
    private String regdate;
    private String updatedate;

}
