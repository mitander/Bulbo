package sysjm3.bulbo.bulbo.service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sysjm3.bulbo.bulbo.model.Card;
import sysjm3.bulbo.bulbo.repositories.CardRepository;

/**
 *
 * @author Christoffer Hansen
 */
@Service
@Transactional
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card saveCard(Card card) {
        return (card != null) ? cardRepository.saveAndFlush(card) : null;
    }

    public void deleteCard(Card card) {
        if (card != null) {
        	Card foundCard = cardRepository.findByUUID(card.getUUID());
        	System.out.println(foundCard.getUUID() + " : " + card.getUUID());
        	cardRepository.deleteById(card.getUUID());
            //cardRepository.delete(foundCard);
        }
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findOne(UUID id) {
        return (id != null) ? cardRepository.findByUUID(id) : null;
    }

    public List<Card> findByWorkspace(UUID id) {
        return (id != null) ? cardRepository.findByWorkspace(id, Sort.by(Sort.Direction.ASC, "uuid")) : null;
    }
}
