package web.mvc.repository.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UserRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // createUser 로직
    @Override
    public void createUser(User user) {
        sqlSession.insert("web.mvc.repository.user.UserRepository.createUser", user);
    }

    // readUser 로직
    @Override
    public User readUser(String id) {
        return sqlSession.selectOne("web.mvc.repository.user.UserRepository.readUser", id);
    }

    // updateUser 로직
    @Override
    public void updateUser(User user) {
        sqlSession.update("web.mvc.repository.user.UserRepository.updateUser", user);
    }

    // deleteUser 로직
    @Override
    public void deleteUser(String id) {
        sqlSession.delete("web.mvc.repository.user.UserRepository.deleteUser", id);
    }
}
