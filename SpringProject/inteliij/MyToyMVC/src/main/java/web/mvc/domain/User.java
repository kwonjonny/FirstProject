package web.mvc.domain;

import lombok.*;
import java.sql.Date;

// lombok 사용
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    // instance 변수 정의
    // USERS table
    private String username;     // user name
    private String email;        // user email
    private String id;           // user id
    private String password;     // user password
    private Integer passwordChangeInterval; // user passwordChangeInterval
    private Date last_password_change;  // user last_password_change
    private boolean isVerified;         // user email 인증 요소
}
