package service.email;

import java.util.UUID;

import javax.mail.MessagingException;

import domain.User;
import util.email.EmailSenderUrl;

public class EmailServiceCreateUserUrl {

	private EmailServiceCreateUserUrl() {
	}

	private static EmailServiceCreateUserUrl emailServiceCreateUserUrl = new EmailServiceCreateUserUrl();

	public static EmailServiceCreateUserUrl getInsatnce() {
		return emailServiceCreateUserUrl;
	}

	public void sendEmailCreateUserUrl(User user) {
		if (user != null) {
			String from = "thistrik@naver.com";
			String password = "";
			String to = user.getEmail();
			String subject = "Welcome Our Member " + user.getUsername();
			String verificationCode = UUID.randomUUID().toString();
			user.setVerificationCode(verificationCode);
	        String htmlMessage = getEmailContent(user);

			
			try {
				EmailSenderUrl.sendEmail(from, password, to, subject, htmlMessage);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	private String getEmailContent(User user) {
	    String url = "http://localhost:8080/MVC2/verify?email=" + user.getEmail() + "&code=" + user.getVerificationCode();
	    return "<h1>Welcome to our Member, " + user.getUsername() + "님!</h1>"
	            + "<p>회원가입을 축하합니다.</p>"
	            + "<p>아래는 회원 정보입니다:</p>"
	            + "<ul>"
	            + "<li>이름: " + user.getUsername() + "</li>"
	            + "<li>이메일: " + user.getEmail() + "</li>"
	            + "<li>아이디: " + user.getId() + "</li>"
	            + "</ul>"
	            + "<p>변경 사항이 있을 경우에는 로그인 후 홈페이지에서 변경 가능합니다.</p>"
	            + "<p>이메일 인증을 위해 아래 링크를 클릭해주세요:</p>"
	            + "<a href=\"" + url + "\">이메일 인증</a>";
	}
}
