package web.mvc.service.user;

import web.mvc.domain.User;

public interface UpdateUserService {

    // 회원 업데이트 service
    public void updateUser(User user) throws Exception;
}
