package sysjm3.bulbo.bulbo.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sysjm3.bulbo.bulbo.model.Card;
import sysjm3.bulbo.bulbo.model.Workspace;

@Repository
public interface CardRepositoryBasic extends JpaRepository<Card, UUID> {
    Card findByUUID(UUID id);
}
