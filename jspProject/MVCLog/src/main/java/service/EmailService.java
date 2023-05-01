package service;

import javax.mail.MessagingException;

import domain.User;
import util.EmailSender;

public class EmailService {

	private EmailService() {
	}

	private static EmailService emailService = new EmailService();

	public static EmailService getInstance() {
		return emailService;
	}
	
	public void sendEmail(User user) {
		if (user != null) {
			String from = "thistrik@naver.com";
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
