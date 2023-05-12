package com.hi.app.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Address {

    private String zipcode;
    private String address1;
    private String address2;
}
