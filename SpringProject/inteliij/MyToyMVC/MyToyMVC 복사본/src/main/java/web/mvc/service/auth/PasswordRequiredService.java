package web.mvc.service.auth;

public interface PasswordRequiredService {
    public boolean isPasswordChangeRequired(String id) throws Exception;
}
