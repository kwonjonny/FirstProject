package web.mvc.service.email;

import org.springframework.stereotype.Service;
import web.mvc.domain.User;
import web.mvc.util.email.EmailSender;
import javax.mail.MessagingException;
import java.util.Random;

// 회원가입 시 인증코드 이메일 발송 서비스
@Service
public class EmailServiceVerifyCode {

    // default 생성자 정의
    private EmailServiceVerifyCode() {
    }

    // SingletonPattern
    private static EmailServiceVerifyCode emailServiceVerifyCode = new EmailServiceVerifyCode();

    public static EmailServiceVerifyCode getInstance() {
        return emailServiceVerifyCode;
    }

    // sendEmailVerifyCode email 발송 -> 난수 를 이메일로 받은 유저가 waiting.jsp 에 입력해야함
    public int sendEmailVerifyCode(User user) throws Exception {
        Random random = new Random();
        int authCode = random.nextInt();
        String authCodeStr = String.format("%06d", authCode); // 난수 숫자 생성

        String from = "thistrik@naver.com";
        String password = "lucy342206!";
        String to = user.getEmail();
        String subject = "Please submit our verifyCode in our page";
        String message = "Your verfiy code is: " + authCodeStr + "\nPlease enter this code on our page to complete the registration process.";

        try {
            EmailSender.sendEmail(from , password, to, subject , message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } return authCode;
    }
}
