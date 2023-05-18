package com.hi.board.domain;


import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRegBoard {

    private String title;
    private String content;
    private String writer;

}
