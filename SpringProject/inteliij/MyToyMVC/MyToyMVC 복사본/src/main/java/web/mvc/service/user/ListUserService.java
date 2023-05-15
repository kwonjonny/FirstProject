package web.mvc.service.user;

import web.mvc.domain.User;

import java.util.List;

public interface ListUserService {

   public List<User> userList() throws Exception;

}
