package pl.collabWriting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.collabWriting.domain.User;

/**
 * @author kattie95
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    User findByUsername(String username);
}
