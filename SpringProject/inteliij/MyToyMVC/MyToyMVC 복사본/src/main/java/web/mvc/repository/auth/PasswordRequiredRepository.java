package web.mvc.repository.auth;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PasswordRequiredRepository {

    // 패스워드 변경 권고 3개월 로직
    boolean isPasswordChangeRequired(Map<String, Object> parameters) throws Exception;
}
