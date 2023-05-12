package com.hi.todo.domain;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ModifyTodoRequest {

    private String tno;
    private String todo;
    private String duedate;
    private String finished;

}
