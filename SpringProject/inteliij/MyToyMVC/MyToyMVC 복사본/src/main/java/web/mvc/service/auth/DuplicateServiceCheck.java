package web.mvc.service.auth;

public interface DuplicateServiceCheck {

    // 회원 가입 시 id 가 중복되었는지 확인 service
    public boolean isDuplicatedId(String id) throws Exception;

    // 회원 가입 시 email 이 중복되었는지 확인 service
    public boolean isDuplicatedEmail(String email) throws Exception;
}
