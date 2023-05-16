package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PasswordRequiredRepositoryImpl implements PasswordRequiredRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public PasswordRequiredRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 패스워드 변경 권고 3개월 로직
    @Override
    public boolean isPasswordChangeRequired(Map<String, Object> parameters) throws Exception {
        return sqlSession.selectOne("web.mvc.repository.auth.PasswordRequiredRepository.isPasswordChangeRequired", parameters);
    }
}
