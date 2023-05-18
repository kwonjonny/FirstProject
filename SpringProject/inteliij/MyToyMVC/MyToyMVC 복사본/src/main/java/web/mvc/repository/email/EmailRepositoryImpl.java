package web.mvc.repository.email;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmailRepositoryImpl implements EmailRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public EmailRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // findByEmail 로직 이메일로 회원 정보 찾기
    @Override
    public User findByEmail(String email) throws Exception {
        return sqlSession.selectOne("web.mvc.repository.email.EmailRepository.findByEmail", email);
    }

    // findByEmailTempPassword 로직 이메일로 회원 정보 찾고 password update
    @Override
    public void findByEmailTempPassword(String email, String password) throws Exception {
        Map<String, Object> newPassword = new HashMap<>();
        newPassword.put("email", email);
        newPassword.put("password", password);
        sqlSession.update("web.mvc.repository.email.EmailRepository.findByEmailTempPassword", newPassword);
    }
}
