package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import web.mvc.domain.UserSecurityDTO;

public interface UserSecurityRepository {

    public UserSecurityDTO readUserId(String id);

}
