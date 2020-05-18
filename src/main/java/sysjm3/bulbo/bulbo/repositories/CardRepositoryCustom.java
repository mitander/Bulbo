package sysjm3.bulbo.bulbo.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import sysjm3.bulbo.bulbo.model.Card;

/**
 *
 * @author Christoffer Hansen
 */
@Repository
public interface CardRepositoryCustom {
    List<Card> findByWorkspace(UUID id, Sort sort);
}
