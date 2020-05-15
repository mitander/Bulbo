package sysjm3.bulbo.Bulbo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sysjm3.bulbo.Bulbo.model.Workspace;

@Repository
public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {
     Workspace findById(long id);
}
