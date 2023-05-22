package com.hi.board.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageOption {

    private BoardSearchOption boardSearchOption;
    private int startNum;
    private int count;




}
