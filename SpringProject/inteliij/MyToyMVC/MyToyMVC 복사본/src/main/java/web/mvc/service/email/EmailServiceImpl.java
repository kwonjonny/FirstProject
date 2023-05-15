package web.mvc.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.repository.email.EmailRepository;
import web.mvc.repository.email.EmailRepositoryImpl;

@Service
public class EmailServiceImpl implements EmailService {

   private final EmailRepository emailRepository;

   @Autowired
   public EmailServiceImpl(EmailRepository emailRepository) {
       this.emailRepository = emailRepository;
   }

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
