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

    private final PasswordRequiredRepository passwordRequiredRepository;

    @Autowired
    public PasswordRequiredServiceImpl(PasswordRequiredRepository passwordRequiredRepository) {
        this.passwordRequiredRepository = passwordRequiredRepository;
    }

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
