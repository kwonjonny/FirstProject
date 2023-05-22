package web.mvc.repository.email;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.User;

@Mapper
public interface EmailRepository {

    // findByEmail 로직 이메일로 회원 정보 찾기
    User findByEmail(String email) throws Exception;

    // findByEmailTempPassword 로직 이메일로 회원 정보 찾고 password 업데이트
    void findByEmailTempPassword(String email, String password) throws Exception;
}
