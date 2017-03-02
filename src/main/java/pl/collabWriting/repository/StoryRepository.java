package pl.collabWriting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.collabWriting.domain.Story;

import java.util.List;

/**
 * @author kattie95
 */

@Repository
public interface StoryRepository extends PagingAndSortingRepository<Story, Long>
{
    List<Story> findAllByOrderByStartedOnDesc();


    /*
    Story findFirstByOrderByLastUpdateDesc();
    * do użycia, jak znajdzie się sposób na lastUpdate
    */

}