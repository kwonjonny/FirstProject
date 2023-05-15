package web.mvc.service.email;

import web.mvc.domain.User;

public interface EmailService {
    public User findByEmail(String email) throws Exception;
}
