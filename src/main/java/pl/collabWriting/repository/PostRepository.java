package pl.collabWriting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.collabWriting.domain.Post;

import java.util.List;

/**
 * @author kattie95
 */

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long>
{
    List<Post> findAllByStoryIdOrderByPostedOnAsc(Long id);

    Post findFirstByOrderByPostedOnDesc();
}
