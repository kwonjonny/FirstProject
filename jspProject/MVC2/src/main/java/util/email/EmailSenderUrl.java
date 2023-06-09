package util.email;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderUrl {

	public static void sendEmail(String from, String password, String to, String subject, String htmlMessage)
			throws MessagingException {
		// SMTP 서버 설정을 위한 Properties 객체 생성
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // SMTP 인증 사용
		props.put("mail.smtp.starttls.enable", "true"); // TLS 보안 연결 사용
		props.put("mail.smtp.host", "smtp.naver.com"); // naver SMTP 서버 주소
		props.put("mail.smtp.port", "465"); // naver SMTP 서버 포트번호
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

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
	    email.setContent(htmlMessage, "text/html; charset=UTF-8"); // 이메일 내용 및 Content-Type 설정

	    // 이메일 전송
	    Transport.send(email);
	}
}
