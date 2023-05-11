package web.mvc.repository.user;

import web.mvc.domain.User;

public interface UserRepository {
    public void createUser(User user);

    public User readUser(String id);

    public void updateUser(User user);

    public void deleteUser(String id);
}
