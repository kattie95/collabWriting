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
    List<Story> findAllByOrderByStartedOnDesc();            //all stories from the newest
    Story findFirstByActiveTrueOrderByStartedOnDesc();      //new and active story
    List<Story> findAllByActiveFalseOrderByStartedOnDesc(); //finished stories from the newest
    List<Story> findAllByActiveTrue();                      //all active stories - for list
}