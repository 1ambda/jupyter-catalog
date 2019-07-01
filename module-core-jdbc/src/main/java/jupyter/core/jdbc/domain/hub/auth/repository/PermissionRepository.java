package jupyter.core.jdbc.domain.hub.auth.repository;

import jupyter.core.jdbc.domain.hub.auth.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
}
