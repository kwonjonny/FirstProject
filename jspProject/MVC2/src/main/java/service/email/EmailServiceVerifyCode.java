package service.email;


import javax.mail.MessagingException;
import java.util.Random;

import domain.User;
import util.email.EmailSender;

public class EmailServiceVerifyCode {

	private EmailServiceVerifyCode() {
	}
	
	private static EmailServiceVerifyCode emailServiceVerifyCode = new EmailServiceVerifyCode();
	
	public static EmailServiceVerifyCode getInstance() {
		return emailServiceVerifyCode;
	}
	
	public int sendEmailVerifyCode(User user) {
		// 인증번호 생성 !
		Random random = new Random();
		int authCode = random.nextInt(1000000); // 난수 생성 
		String authCodeStr = String.format("%06d", authCode); // 난수 6자리를 문자열로 변환
			
		String from = "thistrik@naver.com";
		// 개인정보 보호 
		String password = "";
		String to = user.getEmail();
		String subject = "Please submit our verfifycode in our page";
		String mesage = "Your verfiy code is: " + authCodeStr + "\nPlease enter this code on our page to complete the registration process.";
		
		try {
			EmailSender.sendEmail(from, password, to, subject, mesage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return authCode;
	}
}
