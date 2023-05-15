package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PasswordRequiredRepositoryImpl implements PasswordRequiredRepository {

    private SqlSession sqlSession;

    @Autowired
    public PasswordRequiredRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public boolean isPasswordChangeRequired(Map<String, Object> parameters) throws Exception {
        return sqlSession.selectOne("web.mvc.repository.auth.PasswordRequiredRepository.isPasswordChangeRequired", parameters);
    }
}
