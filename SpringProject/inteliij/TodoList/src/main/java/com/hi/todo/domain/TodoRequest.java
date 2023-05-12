package com.hi.todo.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoRequest {
    // 파라미터 값을 받아서 저장할 변수 정의
    // 변수의 이름은 파라미터의 이름과 같이 정의
    // Java Beans 형식
    private String todo;
    private String duedate;
    
}
