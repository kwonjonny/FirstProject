package web.mvc.repository.auth;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DuplicateCheckRepository {

    // 회원 가입 시 id 가 중복되었는지 확인 repository
    boolean isDuplicatedId(String id) throws Exception;

    // 회원가입 시 email 이 중복되었는지 확인 repository
    boolean isDuplicatedEmail(String email) throws  Exception;
}
