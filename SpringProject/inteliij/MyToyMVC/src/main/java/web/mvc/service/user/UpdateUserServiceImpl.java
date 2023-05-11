package web.mvc.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.user.UserRepository;

@Service
public class UpdateUserServiceImpl implements UpdateUserService{

    // UserDAO interface 인스턴스 변수 정의
    private final UserRepository userRepository;

    // UserDAO interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UpdateUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // updateUser service 로직
    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
