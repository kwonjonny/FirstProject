package web.mvc.service.user;

public interface DeleteUserService {

    // 회원 탈퇴 service
    public boolean deleteUser(String id) throws Exception;

}
