package sysjm3.bulbo.bulbo.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sysjm3.bulbo.bulbo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUUID(UUID id);
}
