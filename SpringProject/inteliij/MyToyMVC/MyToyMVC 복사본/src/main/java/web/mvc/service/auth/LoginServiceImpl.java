package web.mvc.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.auth.UserLoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

    // UserLoginRepository interface 인스턴스 변수 정의
    private final UserLoginRepository userLoginRepository;

    // UserLoginRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public LoginServiceImpl(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    // login service 로직
    @Override
    @Transactional
    public User login(String id, String password) throws Exception {
        return userLoginRepository.login(id, password);
    }

}
