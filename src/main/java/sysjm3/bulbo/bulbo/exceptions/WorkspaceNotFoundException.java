package sysjm3.bulbo.bulbo.exceptions;

import java.util.UUID;

public class WorkspaceNotFoundException extends RuntimeException {
    
    public WorkspaceNotFoundException(UUID workspaceId) {
        super("Could not find workspace by id=" + workspaceId);
    }
    
}
