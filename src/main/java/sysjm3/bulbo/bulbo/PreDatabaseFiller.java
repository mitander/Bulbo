package sysjm3.bulbo.bulbo;

import java.util.Arrays;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sysjm3.bulbo.bulbo.model.Card;
import sysjm3.bulbo.bulbo.model.User;
import sysjm3.bulbo.bulbo.model.Workspace;
import sysjm3.bulbo.bulbo.service.CardService;
import sysjm3.bulbo.bulbo.service.UserService;
import sysjm3.bulbo.bulbo.service.WorkspaceService;

/**
 *
 * @author Christoffer Hansen
 */
@Component
public class PreDatabaseFiller implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreDatabaseFiller.class);

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private CardService cardService;
    
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Create 1 User and save it
        User user1 = new User("_User1", "_User1_Forename", "_User1_Surname", 
                "_User1_Email", "_User1_Password");
        userService.saveUser(user1);
        
        // Create 2 workspaces and save them
        Workspace ws1 = new Workspace("_Workspace1", user1);
        Workspace ws2 = new Workspace("_Workspace2", user1);
        workspaceService.saveWorkspace(ws1);
        workspaceService.saveWorkspace(ws2);
        
        // Create 5 Cards and save them
        cardService.saveCard(new Card("_Card1", "_Card1-content", ws1));
        cardService.saveCard(new Card("_Card2", "_Card2-content", ws1));
        cardService.saveCard(new Card("_Card3", "_Card3-content", ws1));
        cardService.saveCard(new Card("_Card4", "_Card4-content", ws2));
        cardService.saveCard(new Card("_Card5", "_Card5-content", ws2));
        
        // Try to find any and all Users and log them
        userService.findAll().forEach((user) -> {
            LOGGER.info("{}", user);
        });
        
        // Try to find any and all workspaces and log them
        workspaceService.findAll().forEach((workspace) -> {
            LOGGER.info("{}", workspace);
        });
        
        // Try to find any and all cards and log them
        cardService.findAll().forEach((card) -> {
            LOGGER.info("{}", card);
        });
    }
}
