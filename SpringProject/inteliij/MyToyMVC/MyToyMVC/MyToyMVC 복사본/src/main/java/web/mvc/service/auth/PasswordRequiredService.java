package web.mvc.service.auth;

public interface PasswordRequiredService {

    // 패스워드 변경 권고 3개월 로직
    boolean isPasswordChangeRequired(String id) throws Exception;
}
