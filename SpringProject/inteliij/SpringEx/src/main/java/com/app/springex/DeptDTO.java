package com.app.springex;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptDTO {

    private int deptno;
    private String dname;
    private String loc;


    public static void main(String[] args) {
        DeptDTO dept = new DeptDTO(2, "Test", "loc");

        System.out.println(dept);
        dept.setDeptno(10);
        dept.setDname("Accounting");
        dept.setLoc("new york");
        System.out.println(dept.getLoc());


    }

}
