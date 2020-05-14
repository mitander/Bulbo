package sysjm3.bulbo.Bulbo.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import sysjm3.bulbo.Bulbo.model.Card;

@Repository
public interface CardsRepo extends CrudRepository<Card, Integer> {

	List<Card> findByTag(String tag);

}
