package web.mvc.service.user;

import web.mvc.domain.User;

public interface CreateUserService {

    // 회원 가입 service
    public void createUser(User user) throws Exception;

}
