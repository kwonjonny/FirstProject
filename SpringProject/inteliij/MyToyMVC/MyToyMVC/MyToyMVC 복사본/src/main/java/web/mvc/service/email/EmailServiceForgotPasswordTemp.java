package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;
import web.mvc.util.email.EmailSender;

import javax.mail.MessagingException;

// 패스워드 forgot 시 변경된 난수 password 발송 서비스
@Service
public class EmailServiceForgotPasswordTemp {

    // default 생성자 정의
    private EmailServiceForgotPasswordTemp(){
    }

    // SingletonPattern
    private static EmailServiceForgotPasswordTemp emailServiceForgotPasswordTemp = new EmailServiceForgotPasswordTemp();

    public static EmailServiceForgotPasswordTemp getInstance() {
        return emailServiceForgotPasswordTemp;
    }

    // ForgotPassword temp email 발송
    public void sendEmailForgotPasswordTemp(User user) {
        if(user != null) {
            String from = "thistrik@naver.com";
            // 개인정보 보호
            String password = "";
            String to = user.getEmail();
            String subject = "new password informaiton";

            // 보낼 사용자 정보 내용 포함
            String message = "Hello," + user.getUsername() +  "\n\n" + "Here are your new temp password details:\n" +
                   "Password:  " + user.getPassword() + "  please login and change your password again";

            try {
                EmailSender.sendEmail(from, password, to, subject, message);
            } catch (MessagingException e) {
                e.printStackTrace();;
            }
        }
    }
}