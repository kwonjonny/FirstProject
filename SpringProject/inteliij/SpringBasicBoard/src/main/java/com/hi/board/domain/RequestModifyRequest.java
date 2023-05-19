package com.hi.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModifyRequest {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String oldfile;
    private MultipartFile file1;
    private String filename;
}
