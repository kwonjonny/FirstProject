package web.mvc.service.email;

import web.mvc.domain.User;

public interface EmailServiceForgot {

    // findByEmail service 로직
    User findByEmail(String email) throws Exception;

    // findByEmailTempPassword service 로직
    User findByEmailTempPassword(String email) throws Exception;
}
