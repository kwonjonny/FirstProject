package web.mvc.service.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.mvc.domain.User;
import web.mvc.repository.login.UserLoginRepository;

import java.util.*;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserLoginRepository userLoginRepository;

    @Autowired
    public CustomUserDetailsService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        log.info("isOkLoadUserByUsername");
        User user = null;
        try {
            user = userLoginRepository.loadUserByUsername(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(user == null) {
            throw  new UsernameNotFoundException("user not found");
        }
        // 권한 목록 생성
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 예시로 ROLE_USER 권한을 부여하였습니다.
        // 실제로는 데이터베이스에서 사용자의 권한에 따라 동적으로 권한을 부여해야 합니다.
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}
