package jupyter.core.jdbc.domain.hub.auth.repository;

import jupyter.core.jdbc.domain.hub.auth.entity.PermissionToRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionToRoleRepository extends PagingAndSortingRepository<PermissionToRole, Long> {
}
