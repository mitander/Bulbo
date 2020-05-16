package sysjm3.bulbo.bulbo.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sysjm3.bulbo.bulbo.model.Workspace;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
     Workspace findByUUID(UUID id);
}
