package service.email;

import javax.mail.MessagingException;

import domain.User;
import util.email.EmailSender;

public class EmailServiceForgotPassword {

	private EmailServiceForgotPassword() {
	}

	private static EmailServiceForgotPassword emailService = new EmailServiceForgotPassword();

	public static EmailServiceForgotPassword getInstance() {
		return emailService;
	}

	public void sendEmail(User user) {
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
