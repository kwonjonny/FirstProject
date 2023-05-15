package web.mvc.service.auth;

public interface DuplicateServiceCheck {

    public boolean isDuplicatedId(String id) throws Exception;

    public boolean isDuplicatedEmail(String email) throws Exception;
}
