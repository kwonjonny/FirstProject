package web.mvc.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.user.UserRepository;
import web.mvc.service.email.EmailServiceDeleteUser;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    // UserDAO interface 인스턴스 변수 정의
    private final UserRepository userRepository;

    // UserDAO interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public DeleteUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // deleteUser service 로직
    @Override
    @Transactional
    public boolean deleteUser(String id) throws Exception {
        User user = userRepository.readUser(id);
        if(user != null) {
            EmailServiceDeleteUser.getInstance().sendEmilDelete(user);
        }
        userRepository.deleteUser(id);
        return false;
    }
}
