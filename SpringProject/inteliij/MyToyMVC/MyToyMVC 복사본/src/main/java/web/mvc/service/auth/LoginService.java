package web.mvc.service.auth;

import web.mvc.domain.User;

public interface LoginService {
    public User login(String id, String password) throws Exception;
}
