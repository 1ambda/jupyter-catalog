package jupyter.core.jdbc.domain.hub.auth.repository;

import jupyter.core.jdbc.domain.hub.auth.entity.RoleToUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleToUserRepository extends PagingAndSortingRepository<RoleToUser, Long> {
}
