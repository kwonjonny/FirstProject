package web.mvc.repository.user;

import web.mvc.domain.User;

import java.util.List;

public interface UserRepository {
    public void createUser(User user) throws Exception;

    public User readUser(String id) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUser(String id) throws Exception;

    public List<User> listUser() throws Exception;
}
