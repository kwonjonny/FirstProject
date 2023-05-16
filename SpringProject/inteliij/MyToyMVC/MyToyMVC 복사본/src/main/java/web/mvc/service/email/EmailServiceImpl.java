package web.mvc.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.email.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

    // EmailRepository interface 인스턴스 변수 정의
   private final EmailRepository emailRepository;

   // EmailRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
   @Autowired
   public EmailServiceImpl(EmailRepository emailRepository) {
       this.emailRepository = emailRepository;
   }

    // findByEmail service 로직
    // 회원의 email 이 있으면 EmailServiceForgotPassword 로 회원 정보를 발송
    @Override
    @Transactional
    public User findByEmail(String email) throws Exception {
        User user = emailRepository.findByEmail(email);
        if(user != null) {
            EmailServiceForgotPassword.getInstance().sendEmailForgotPassword(user);
        }
        return user;
    }
}
