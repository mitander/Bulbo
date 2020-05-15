package sysjm3.bulbo.Bulbo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import sysjm3.bulbo.Bulbo.model.Card;
import sysjm3.bulbo.Bulbo.model.Workspace;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
	List<Card> findById(long id);
        List<Card> findByWorkspace(Workspace workspace, Sort sort);
}
