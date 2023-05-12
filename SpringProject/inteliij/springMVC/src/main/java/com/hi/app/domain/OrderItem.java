package com.hi.app.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {
    private String itemId;
    private int number;
    private String remark;
}
