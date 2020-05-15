package sysjm3.bulbo.Bulbo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;

import sysjm3.bulbo.Bulbo.exceptions.CardNotFoundException;
import sysjm3.bulbo.Bulbo.exceptions.WorkspaceNotFoundException;
import sysjm3.bulbo.Bulbo.model.Card;
import sysjm3.bulbo.Bulbo.repository.CardRepository;
import sysjm3.bulbo.Bulbo.repository.WorkspaceRepository;
import sysjm3.bulbo.Bulbo.model.Workspace;

/**
 * The controller class for the JPA related mappings. The REST API endpoints.
 * e.g. GET, POST, DELETE
 *
 */
@RestController
public class JpaController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    /**
     * GET mapping for all tuples in the cards table at the /cards URL
     *
     * @return Query result from the GET request in JSON format
     */
    @GetMapping("/cards")
    public List<Card> allCards() {
        return (List<Card>) cardRepository.findAll();
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
    public Card createCard(@RequestBody Card card) {
        return cardRepository.save(card);
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
        cardRepository.delete(card);
    }

    /**
     * GET mapping for /cards/{id} URL. Returns the tuple with the ID given 
     * as parameter
     * 
     * @param cardId ID of the Card you want to view
     * @return Query result in the form of JSON format representing the Card
     * that was fetched if it exists
     */
    @GetMapping("/cards/{id}")
    public Card getCardById(@PathVariable Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new CardNotFoundException(cardId));
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
    @GetMapping("/cards?by=workspace")
    public Card getCardByWorkspace(@RequestBody Workspace workspace) {
        if (workspace != null) {
            return (Card) cardRepository.findByWorkspace(workspace, 
                    Sort.by(Sort.Direction.ASC, "id"));
        } else {
            return null;
        }
    }

    /**
     * GET mapping for all workspaces in the workspaces table at 
     * the /workspaces URL
     *
     * @return Query result from the GET request in JSON format
     */
    @GetMapping("/workspaces")
    public List<Workspace> allWorkspaces() {
        return (List<Workspace>) workspaceRepository.findAll();
    }
    
    /**
     * POST mapping for /workspaces URL. Essentially creates a new 
     * Workspace object and inserts it in the table workspaces
     *
     * @param workspace Request body in the format of JSON 
     * representing the values for the workspace object
     * @return Query result in the form of JSON format representing the 
     * Workspace that was just created
     */
    @PostMapping("/workspaces")
    public Workspace createWorkspace(@RequestBody Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    /**
     * DELETE mapping for /workspaces URL. It should delete the Workspace 
     * given as parameter from the workspaces table
     * 
     * @param workspace Request body in the format of JSON representing the 
     * values for the Workspace object
     */
    @DeleteMapping("/workspaces")
    public void deleteWorkspace(@RequestBody Workspace workspace) {
        if (workspace != null) {
            workspaceRepository.delete(workspace);
        }
    }

     /**
     * GET mapping for /workspace/{id} URL. Returns the tuple with the ID given 
     * as parameter
     * 
     * @param workspaceId ID of the Card you want to view
     * @return Query result in the form of JSON format representing the Card
     * that was fetched if it exists
     */
    @GetMapping("/workspace/{id}")
    public Workspace getWorkspaceById(@PathVariable Long workspaceId) {
        return workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new WorkspaceNotFoundException(workspaceId));
    }

}
