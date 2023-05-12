package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.mvc.domain.UserSecurityDTO;

@Repository
public class UserSecurityRepositoryImpl implements UserSecurityRepository {

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UserSecurityRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // SpringSecurity readUserId 로직
    @Override
    public UserSecurityDTO readUserId(String id) {
        return sqlSession.selectOne("web.mvc.repository.auth.UserSecurityRepository.readUserId");
    }

}
