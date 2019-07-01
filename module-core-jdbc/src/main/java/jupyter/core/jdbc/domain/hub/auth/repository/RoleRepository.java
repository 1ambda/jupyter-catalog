package jupyter.core.jdbc.domain.hub.auth.repository;

import jupyter.core.jdbc.domain.hub.auth.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
