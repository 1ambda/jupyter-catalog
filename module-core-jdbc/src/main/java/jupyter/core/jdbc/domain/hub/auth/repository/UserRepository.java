package jupyter.core.jdbc.domain.hub.auth.repository;


import jupyter.core.jdbc.domain.hub.auth.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
  extends PagingAndSortingRepository<User, Long> {
}
