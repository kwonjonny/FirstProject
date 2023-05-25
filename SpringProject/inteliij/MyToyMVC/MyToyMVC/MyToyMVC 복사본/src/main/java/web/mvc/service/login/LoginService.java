package web.mvc.service.login;

import web.mvc.domain.User;

public interface LoginService {

    // login service
    User login(String id, String password) throws Exception;
}
