package service;

import domain.User;
import dao.UserDAO;

public class UserService {
    private UserDAO userDao = new UserDAO();

    public boolean join(User user) {
        // 비밀번호 암호화 등 필요한 처리를 수행할 수 있습니다.
        return userDao.insert(user);
    }

    public boolean login(String id, String password) {
        // 비밀번호 암호화 등 필요한 처리를 수행할 수 있습니다.
        return userDao.findByIdAndPassword(id, password) != null;
    }

    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
