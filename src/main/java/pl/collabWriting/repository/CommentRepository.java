package pl.collabWriting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.collabWriting.domain.Comment;

import java.util.List;

/**
 * @author kattie95
 */

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>
{
    List<Comment> findAllByPostIdOrderByCommentedOnDesc(Long id);
}
