package web.mvc.repository.login;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.User;

@Mapper
public interface UserLoginRepository {

    // 유저 로그인
    User login(String id, String password) throws Exception;

    // Spring Security => loadUserByUsername
    User loadUserByUsername(String id) throws Exception;
}
