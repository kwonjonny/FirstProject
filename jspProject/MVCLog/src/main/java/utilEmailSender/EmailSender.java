package utilEmailSender;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
	/**
	 * 이메일을 전송하는 메서드
	 * 
	 * @param from     보내는 사람 이메일 주소
	 * @param password 보내는 사람 이메일 비밀번호
	 * @param to       받는 사람 이메일 주소
	 * @param subject  이메일 제목
	 * @param message  이메일 내용
	 * @throws MessagingException 메시지 전송 과정에서 오류 발생 시
	 */
	public static void sendEmail(String from, String password, String to, String subject, String message) throws MessagingException {

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
		email.setText(message); // 이메일 내용 설정

		// 이메일 전송
		Transport.send(email);
	}
}
