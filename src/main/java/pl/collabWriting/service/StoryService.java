package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.collabWriting.domain.Story;
import pl.collabWriting.repository.StoryRepository;

import java.util.List;

/**
 * @author kattie95
 */
@Service
public class StoryService
{
    private StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> list()
    {
        return storyRepository.findAllByOrderByStartedOnDesc();
    }
}
