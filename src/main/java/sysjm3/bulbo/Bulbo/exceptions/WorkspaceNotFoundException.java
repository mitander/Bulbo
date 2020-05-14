package sysjm3.bulbo.Bulbo.exceptions;

public class WorkspaceNotFoundException extends RuntimeException {
    
    public WorkspaceNotFoundException(Long workspaceId) {
        super("Could not find workspace by id=" + workspaceId);
    }
    
}
