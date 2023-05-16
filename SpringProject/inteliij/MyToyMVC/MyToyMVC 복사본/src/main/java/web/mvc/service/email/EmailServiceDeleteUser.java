package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;
import web.mvc.util.email.EmailSender;

import javax.mail.MessagingException;

// 회원탈퇴 시 이메일 발송 서비스
@Service
public class EmailServiceDeleteUser {

    // default 생성자 정의
    private EmailServiceDeleteUser() {
    }

    // SingletonPattern
    private static EmailServiceDeleteUser emailServiceDeleteUser = new EmailServiceDeleteUser();

    public static EmailServiceDeleteUser getInstance() {
        return emailServiceDeleteUser;
    }

    // DeleteUser Bye email 발송
    public void sendEmilDelete(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        String from = "thistrik@naver.com";
        // 개인정보 보호
        String password = "";
        String to = user.getEmail();
        String subject = "Delete Member ";
        String message = "지금까지 저희 웹 서비스를 이용해주셔서 감사합니다 귀하의 개인 정보는 더 이상 보관되지 않음을 알립니다";

        try {
            EmailSender.sendEmail(from, password, to, subject, message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
