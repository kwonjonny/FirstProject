package service.email;

import javax.mail.MessagingException;

import domain.User;
import util.email.EmailSender;


public class EmailServiceDeleteUser {

	private EmailServiceDeleteUser() {
	}
	
	private static EmailServiceDeleteUser emailServiceDeleteUser = new EmailServiceDeleteUser();
	
	public static EmailServiceDeleteUser getInsatnce() {
		return emailServiceDeleteUser;
	}
	
	public void sendEmailDeleteUser(User user) throws IllegalArgumentException {
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
