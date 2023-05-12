package web.mvc.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.mvc.domain.UserSecurityDTO;
import web.mvc.repository.auth.UserSecurityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // UserSecurityRepository interface 인스턴스 변수 정의
    private UserSecurityRepository userSecurityRepository;

    // UserSecurityRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UserDetailsServiceImpl(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserSecurityDTO userSecurityDTO = userSecurityRepository.readUserId(id);
        if(userSecurityDTO == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserSecurityDTO(userSecurityDTO);
    }
}
