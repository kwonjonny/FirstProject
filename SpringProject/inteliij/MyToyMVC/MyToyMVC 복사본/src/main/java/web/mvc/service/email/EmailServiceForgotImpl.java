package web.mvc.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.email.EmailRepository;
import web.mvc.util.passwordGenerator.PasswordGenerator;

@Service
public class EmailServiceForgotImpl implements EmailServiceForgot {

    // EmailRepository interface 인스턴스 변수 정의
   private final EmailRepository emailRepository;

   // EmailRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
   @Autowired
   public EmailServiceForgotImpl(EmailRepository emailRepository) {
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

    // findByEmailTempPassword service 로직
    // 회원의 email 이 있으면 EmailServiceForgotPasswordTemp 로 회원 정보를 발송
    @Override
    @Transactional
    public User findByEmailTempPassword(String email) throws Exception {
       User user = emailRepository.findByEmail(email);
       if (user != null) {
           // user 패스워드 난수 업데이트
           String newPassword = PasswordGenerator.getInstance().generateTempPassword();
           user.setPassword(newPassword);
           emailRepository.findByEmailTempPassword(email, newPassword);
           EmailServiceForgotPasswordTemp.getInstance().sendEmailForgotPasswordTemp(user);
       }
        return user;
    }
}
