package jupyter.core.jdbc.domain.hub.auth.repository;


import jupyter.core.jdbc.domain.hub.auth.entity.AuthIdentity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthIdentityRepository
  extends PagingAndSortingRepository<AuthIdentity, Long> {
}
