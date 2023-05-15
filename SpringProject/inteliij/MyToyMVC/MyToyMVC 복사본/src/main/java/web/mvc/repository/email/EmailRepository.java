package web.mvc.repository.email;

import web.mvc.domain.User;

public interface EmailRepository {
    public User findByEmail(String email) throws Exception;
}
