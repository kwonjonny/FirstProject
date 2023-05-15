package web.mvc.repository.auth;

public interface DuplicateCheckRepository {

    public boolean isDuplicatedId(String id) throws Exception;

    public boolean isDuplicatedEmail(String email) throws  Exception;
}
