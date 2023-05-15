package web.mvc.repository.auth;

import java.util.Map;

public interface PasswordRequiredRepository {

    boolean isPasswordChangeRequired(Map<String, Object> parameters) throws Exception;
}
