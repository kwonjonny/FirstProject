package web.mvc.service.email;

import web.mvc.domain.User;

public interface EmailServiceForgot {
    public User findByEmail(String email) throws Exception;

    public User findByEmailTempPassword(String email) throws Exception;
}
