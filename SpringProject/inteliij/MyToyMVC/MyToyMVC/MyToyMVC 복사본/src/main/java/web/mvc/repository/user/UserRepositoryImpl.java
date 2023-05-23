package web.mvc.repository.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UserRepositoryImpl(SqlSession sqlSession) throws Exception {
        this.sqlSession = sqlSession;
    }

    // 회원가입 로직
    @Override
    public void createUser(User user) throws Exception {
        sqlSession.insert("web.mvc.repository.user.UserRepository.createUser", user);
    }

    // 회원찾기 로직
    @Override
    public User readUser(String id) throws Exception {
        return sqlSession.selectOne("web.mvc.repository.user.UserRepository.readUser", id);
    }

    // 회원 업데이트 로직
    @Override
    public void updateUser(User user) throws Exception {
        sqlSession.update("web.mvc.repository.user.UserRepository.updateUser", user);
    }

    // 회원 탈퇴 로직
    @Override
    public void deleteUser(String id) throws Exception {
        sqlSession.delete("web.mvc.repository.user.UserRepository.deleteUser", id);
    }

    // 회원 리스트 로직
    @Override
    public List<User> listUser(String id) throws Exception {
        return sqlSession.selectList("web.mvc.repository.user.UserRepository.ListUser", id);
    }
}
