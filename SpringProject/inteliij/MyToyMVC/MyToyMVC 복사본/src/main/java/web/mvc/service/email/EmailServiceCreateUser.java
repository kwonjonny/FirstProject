package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;
import web.mvc.util.email.EmailSender;

import javax.mail.MessagingException;

@Service
public class EmailServiceCreateUser {

    private EmailServiceCreateUser(){
    }

    private static EmailServiceCreateUser emailServiceCreateUser = new EmailServiceCreateUser();

    public static EmailServiceCreateUser getInstance() {
        return emailServiceCreateUser;
    }

    public void sendEmailCreateUser(User user) {
        if (user != null) {
            String from = "thistrik@naver.com";
            // 개인정보 보호
            String password = "";
            String to = user.getEmail();
            String subject = "Welcome Our Member " + user.getUsername();
            String message = "Welcome to our Member, " + user.getUsername() + "님, 회원가입을 축하합니다.\n\n" + "아래는 회원 정보입니다:\n" + "이름: "
                    + user.getUsername() + "\n" + "이메일: " + user.getEmail() + "\n" + "아이디: " + user.getId() + "\n"
                    + "\n변경 사항이 있을 경우에는 로그인 후 홈페이지에서 변경 가능합니다.";
            try {
                EmailSender.sendEmail(from, password, to, subject, message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
