package com.hi.deptspring.deptspring.domain;

import lombok.*;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DeptDTO {

    private int deptno;
    private String dname;
    private String loc;


}
