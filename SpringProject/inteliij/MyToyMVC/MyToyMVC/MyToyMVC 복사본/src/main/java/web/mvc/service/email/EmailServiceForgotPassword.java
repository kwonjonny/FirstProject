package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;

import javax.mail.MessagingException;
import web.mvc.util.email.EmailSender;

// 패스워드 forgot 시 이메일 발송 서비스
@Service
public class EmailServiceForgotPassword {

    // default 생성자 정의
    private EmailServiceForgotPassword(){
    }

    // SingletonPattern
    private static EmailServiceForgotPassword emailServiceForgotPassword = new EmailServiceForgotPassword();

    public static EmailServiceForgotPassword getInstance() {
        return emailServiceForgotPassword;
    }

    // ForgotPassword email 발송
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
