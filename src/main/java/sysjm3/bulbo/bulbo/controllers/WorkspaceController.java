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

import sysjm3.bulbo.bulbo.model.Workspace;
import sysjm3.bulbo.bulbo.service.WorkspaceService;

/**
 * The controller class for the endpoint related mappings for Workspace.
 * e.g. GET, POST, DELETE
 *
 */
@RestController
public class WorkspaceController {
    
    @Autowired
    WorkspaceService workspaceService;
    
    /**
     * GET mapping for all workspaces in the workspaces table at 
     * the /workspaces URL
     *
     * @return Query result from the GET request in JSON format
     */
    @GetMapping("/workspaces")
    public List<Workspace> allWorkspaces() {
        return workspaceService.findAll();
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
    public Workspace saveWorkspace(@RequestBody Workspace workspace) {
        return workspaceService.saveWorkspace(workspace);
    }

    /**
     * DELETE mapping for /workspaces URL. It should delete the Workspace 
     * given as parameter from the workspaces table
     * 
     * @param id Request body in the format of JSON representing the 
     * values for the Workspace object
     */
    @DeleteMapping("/workspaces/{id}")
    public void deleteWorkspaceById(@PathVariable UUID id) {
        if (id != null) {
            workspaceService.deleteWorkspaceById(id);
        }
    }

     /**
     * GET mapping for /workspace/{id} URL. Returns the tuple with the ID given 
     * as parameters
     * 
     * @param id ID of the Card you want to view
     * @return Query result in the form of JSON format representing the Card
     * that was fetched if it exists
     */
    @GetMapping("/workspaces/{id}")
    public Workspace getWorkspaceById(@PathVariable UUID id) {
        return workspaceService.findOne(id);
    }
    
}
