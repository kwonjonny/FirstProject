package com.hi.app.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    // 인스턴스 변수 정의
    // parameter 이름과 동일하게 선언 해야한다
    private String keyword;
    private int tno;
    private int page;

}
