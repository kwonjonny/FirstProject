package web.mvc.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mvc.repository.auth.PasswordRequiredRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PasswordRequiredServiceImpl implements PasswordRequiredService {

    // PasswordRequiredService interface 인스턴스 변수 정의
    private final PasswordRequiredRepository passwordRequiredRepository;

    // PasswordRequiredService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public PasswordRequiredServiceImpl(PasswordRequiredRepository passwordRequiredRepository) {
        this.passwordRequiredRepository = passwordRequiredRepository;
    }

    // 패스워드 변경 권고 3개월 로직
    @Override
    public boolean isPasswordChangeRequired(String id) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        Date threeMonthsAgo = calendar.getTime();
        parameters.put("threeMonthsAgo", threeMonthsAgo);

        return passwordRequiredRepository.isPasswordChangeRequired(parameters);
    }
}
