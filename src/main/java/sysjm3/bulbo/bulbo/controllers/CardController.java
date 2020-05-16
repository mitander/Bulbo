package sysjm3.bulbo.bulbo.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sysjm3.bulbo.bulbo.model.Card;
import sysjm3.bulbo.bulbo.model.Workspace;
import sysjm3.bulbo.bulbo.service.CardService;

/**
 * The controller class for the endpoint related mappings for Card.
 * e.g. GET, POST, DELETE
 *
 */
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    /**
     * GET mapping for all tuples in the cards table at the /cards URL
     *
     * @return Query result from the GET request in JSON format
     */
    @GetMapping("/cards")
    public List<Card> allCards() {
        return cardService.findAll();
    }

    /**
     * POST mapping for /cards URL. Essentially creates a new Card object and
     * inserts it in the table cards
     *
     * @param card Request body in the format of JSON representing the values
     * for the Card object
     * @return Query result in the form of JSON format representing the Card
     * that was just created
     */
    @PostMapping("/cards")
    public Card saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    /**
     * DELETE mapping for /cards URL. It should delete the Card given as 
     * parameter from the cards table
     * 
     * @param card Request body in the format of JSON representing the values
     * for the Card object
     */
    @DeleteMapping("/cards")
    public void deleteCard(@RequestBody Card card) {
        cardService.deleteCard(card);
    }

    /**
     * GET mapping for /cards/{id} URL. Returns the tuple with the ID given 
     * as parameter
     * 
     * @param cardUuid ID of the Card you want to view
     * @return Query result in the form of JSON format representing the Card
     * that was fetched if it exists
     */
    @GetMapping("/cards/{id}")
    public Card getCardById(@PathVariable UUID cardUuid) {
        return cardService.findOne(cardUuid);
    }

    /**
     * GET mapping for /cards?by=workspace URL. Will return all the cards 
     * that has the given parameter workspace object as a field value
     * 
     * @param workspace Request body in the format of JSON representing 
     * the values of the Workspace object
     * @return Query results in the form of JSON format representing the cards
     * that was fetched
     */
    @GetMapping("/cards?by=w")
    public List<Card> getCardByWorkspace(@RequestBody Workspace workspace) {
        return cardService.findByWorkspace(workspace);
    }
}
