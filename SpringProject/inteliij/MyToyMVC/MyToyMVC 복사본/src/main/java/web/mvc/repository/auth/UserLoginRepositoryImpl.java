package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.User;

@Repository
public class UserLoginRepositoryImpl implements UserLoginRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자 정의
    @Autowired
    public UserLoginRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // login 로직
    @Override
    public User login(String id, String password) throws Exception {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        return sqlSession.selectOne("web.mvc.repository.auth.UserLoginRepository.login", user);
    }
}
