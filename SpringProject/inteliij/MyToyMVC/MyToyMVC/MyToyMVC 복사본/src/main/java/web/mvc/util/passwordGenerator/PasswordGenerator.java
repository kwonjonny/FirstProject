package web.mvc.util.passwordGenerator;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Random;

@Log4j2
@Component
public class PasswordGenerator {

    // default 생성자
    private PasswordGenerator(){}

    // SingletonPattern
    private static PasswordGenerator passwordGenerator = new PasswordGenerator();

    public static PasswordGenerator getInstance() {
        return passwordGenerator;
    }

    // 사용할 임시 패스워드 패턴 문자
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";

    // 사용할 임시 패스워드 패턴 문자 길이 제한
    private static final int PasswordLength = 13;

    public String generateTempPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for(int i=0; i<PasswordLength; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char character = CHARACTERS.charAt(index);
            stringBuilder.append(character);
        }
        String tempPassword = stringBuilder.toString();
        log.info("난수 password : " + tempPassword);

        return tempPassword;
    }
}
