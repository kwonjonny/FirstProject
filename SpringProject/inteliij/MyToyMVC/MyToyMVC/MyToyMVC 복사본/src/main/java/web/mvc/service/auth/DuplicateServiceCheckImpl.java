package web.mvc.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mvc.repository.auth.DuplicateCheckRepository;

@Service
public class DuplicateServiceCheckImpl implements DuplicateServiceCheck {

    // DuplicateCheckRepository interface 인스턴스 변수 정의
    private final DuplicateCheckRepository duplicateCheckRepository;

    // DuplicateCheckRepository interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public DuplicateServiceCheckImpl(DuplicateCheckRepository duplicateCheckRepository) {
        this.duplicateCheckRepository = duplicateCheckRepository;
    }

    // 회원 가입 시 id 가 중복되었는지 확인
    @Override
    public boolean isDuplicatedId(String id) throws Exception {
        return duplicateCheckRepository.isDuplicatedId(id);
    }

    // 회원 가입 시 email 이 중복되었는지 확인
    @Override
    public boolean isDuplicatedEmail(String email) throws Exception {
        return duplicateCheckRepository.isDuplicatedEmail(email);
    }
}
