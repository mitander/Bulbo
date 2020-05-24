package sysjm3.bulbo.bulbo.service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysjm3.bulbo.bulbo.model.User;
import sysjm3.bulbo.bulbo.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User saveUser(User user) {
        return (user != null) ? 
                userRepository.saveAndFlush(user) : null;
    }

    public void deleteUserById(UUID id) {
        if (id != null) {
            userRepository.deleteById(id);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(UUID id) {
        return (id != null) ? userRepository.findByUUID(id) : null;
    }
    
}
