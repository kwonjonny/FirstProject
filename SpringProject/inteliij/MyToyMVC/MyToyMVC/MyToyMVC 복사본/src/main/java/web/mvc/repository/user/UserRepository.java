package web.mvc.repository.user;

import org.apache.ibatis.annotations.Mapper;
import web.mvc.domain.User;

import java.util.List;

@Mapper
public interface UserRepository {

    // 회원 가입
    void createUser(User user) throws Exception;

    // 회원 찾기
    User readUser(String id) throws Exception;

    // 회원 업데이트
    void updateUser(User user) throws Exception;

    // 회원 탈퇴
    void deleteUser(String id) throws Exception;

    // 회원 리스트
    List<User> listUser(String id) throws Exception;
}
