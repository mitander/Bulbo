package sysjm3.bulbo.bulbo.exceptions;

import java.util.UUID;
import sysjm3.bulbo.bulbo.model.Workspace;

public class CardNotFoundException extends RuntimeException {
    
    public CardNotFoundException(UUID cardId) {
        super("Could not find card by id=" + cardId);
    }
    
    public CardNotFoundException(Workspace workspace) {
        super("Could not find card by workspace=" + workspace);
    }
    
}
