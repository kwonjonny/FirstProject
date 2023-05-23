package web.mvc.service.user;

import web.mvc.domain.User;
import java.util.List;

public interface ListUserService {

   // 회원 리스트 service
   public List<User> userList(String id) throws Exception;

}
