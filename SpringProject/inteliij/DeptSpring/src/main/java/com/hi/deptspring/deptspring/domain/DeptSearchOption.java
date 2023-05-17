package com.hi.deptspring.deptspring.domain;


import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptSearchOption {

    private String searchType;
    private String keyword;
}
