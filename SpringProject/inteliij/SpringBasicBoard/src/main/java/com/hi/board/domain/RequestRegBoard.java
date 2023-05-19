package com.hi.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRegBoard {

    private String title;
    private String content;
    private String writer;
    private MultipartFile file1;    // 사용자로부터 받는 파일 객체
    private String filename;            // DB에 저장할 File 이름

}
