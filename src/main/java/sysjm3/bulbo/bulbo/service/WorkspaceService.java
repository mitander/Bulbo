package sysjm3.bulbo.bulbo.service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysjm3.bulbo.bulbo.model.Workspace;
import sysjm3.bulbo.bulbo.repositories.WorkspaceRepository;

/**
 *
 * @author Christoffer Hansen
 */
@Service
@Transactional
public class WorkspaceService {
    
    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Workspace saveWorkspace(Workspace workspace) {
        return (workspace != null) ? 
                workspaceRepository.saveAndFlush(workspace) : null;
    }

    public void deleteWorkspace(Workspace workspace) {
        if (workspace != null) {
            workspaceRepository.delete(workspace);
        }
    }

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    public Workspace findOne(UUID id) {
        return (id != null) ? workspaceRepository.findByUUID(id) : null;
    }
   
}
