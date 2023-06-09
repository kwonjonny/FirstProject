package web.mvc.repository.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    // 유저 로그인 로직
    @Override
    public User login(String id, String password) throws Exception {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        return sqlSession.selectOne("web.mvc.repository.login.UserLoginRepository.login", user);
    }

    // Spring Security => loadUserByUsername
    @Override
    public User loadUserByUsername(String id) throws Exception {
        return sqlSession.selectOne("web.mvc.repository.login.UserLoginRepository.loadUserByUsername", id);
    }
}