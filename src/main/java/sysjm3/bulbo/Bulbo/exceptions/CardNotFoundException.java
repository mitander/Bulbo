package sysjm3.bulbo.Bulbo.exceptions;

import sysjm3.bulbo.Bulbo.model.Workspace;

public class CardNotFoundException extends RuntimeException {
    
    public CardNotFoundException(Long cardId) {
        super("Could not find card by id=" + cardId);
    }
    
    public CardNotFoundException(Workspace workspace) {
        super("Could not find card by workspace=" + workspace);
    }
    
}
