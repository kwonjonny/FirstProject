package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;

import javax.mail.MessagingException;
import web.mvc.util.email.EmailSender;

@Service
public class EmailServiceForgotPassword {

    // default 생성자 정의
    private EmailServiceForgotPassword(){
    }

    private static EmailServiceForgotPassword emailServiceForgotPassword = new EmailServiceForgotPassword();

    public static EmailServiceForgotPassword getInstance() {
        return emailServiceForgotPassword;
    }

    public void sendEmailForgotPassword(User user) {
        if (user != null) {
            String from = "thistrik@naver.com";
            // 개인정보 보호
            String password = "";
            String to = user.getEmail();
            String subject = "Account informaiton";

            // 보낼 사용자 정보 내용 포함
            String message = "Hello, " + user.getUsername() + "\n\n" + "Here are your account details:\n" + "Username: "
                    + user.getUsername() + "\n" + "Email: " + user.getEmail() + "\n" + "ID: " + user.getId() + "\n"
                    + "Password: " + user.getPassword();

            try {
                EmailSender.sendEmail(from, password, to, subject, message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}
