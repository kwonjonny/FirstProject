package web.mvc.repository.auth;

import web.mvc.domain.User;

public interface UserLoginRepository {
    public User login(String id, String password) throws Exception;
}
