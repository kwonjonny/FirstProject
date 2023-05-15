package web.mvc.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mvc.repository.auth.DuplicateCheckRepository;

@Service
public class DuplicateServiceCheckImpl implements DuplicateServiceCheck {

    private final DuplicateCheckRepository duplicateCheckRepository;

    @Autowired
    public DuplicateServiceCheckImpl(DuplicateCheckRepository duplicateCheckRepository) {
        this.duplicateCheckRepository = duplicateCheckRepository;
    }

    @Override
    public boolean isDuplicatedId(String id) throws Exception {
        return duplicateCheckRepository.isDuplicatedId(id);
    }

    @Override
    public boolean isDuplicatedEmail(String email) throws Exception {
        return duplicateCheckRepository.isDuplicatedEmail(email);
    }
}
