package web.mvc.util.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// Email 을 발송해주는 클래스
public class EmailSender {

    public static void sendEmail(String from, String password, String to, String subject, String message) throws MessagingException {

        // SMTP 서버 설정을 위한 Properties 객체 생성
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // SMTP 인증 사용
        props.put("mail.smtp.starttls.enable", "true"); // TLS 보안 연결 사용
        props.put("mail.smtp.host", "smtp.naver.com"); // naver SMTP 서버 주소
        props.put("mail.smtp.port", "587"); // naver SMTP 서버 포트번호
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Eclipse 에서는 TLsv1.2 설정 안해줘도 됬지만 Intellij 에서는 설정 해줘야한다


        // SMTP 서버 인증을 위한 Authenticator 객체 생성
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // SMTP 세션 생성
        Session session = Session.getInstance(props, auth);

        // 전송할 이메일 생성
        Message email = new MimeMessage(session);
        email.setFrom(new InternetAddress(from)); // 보내는 사람 이메일 주소 설정
        email.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 받는 사람 이메일 주소 설정
        email.setSubject(subject); // 이메일 제목 설정
        email.setText(message); // 이메일 내용 설정

        // 이메일 전송
        Transport.send(email);
    }
}