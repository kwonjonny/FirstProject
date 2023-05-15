package web.mvc.repository.auth;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DuplicateCheckRepositoryImpl implements DuplicateCheckRepository{

    // MyBatis SqlSession 인스턴스 변수 정의
    private SqlSession sqlSession;

    // MyBatis SqlSession 인스턴스 변수 초기화 매개변수로 받는 생성자 정의
    @Autowired
    public DuplicateCheckRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public boolean isDuplicatedId(String id) throws Exception {
        Integer count = sqlSession.selectOne("web.mvc.repository.email.EmailRepository.isDuplicatedId", id);
        return count != null && count > 0;
    }

    @Override
    public boolean isDuplicatedEmail(String email) throws Exception {
        Integer count = sqlSession.selectOne("web.mvc.repository.email.EmailRepository.isDuplicatedEmail", email);
        return count != null && count > 0;
    }
}
