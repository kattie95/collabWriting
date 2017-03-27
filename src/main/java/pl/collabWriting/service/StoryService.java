package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

    public List<Story> list()
    {
        return storyRepository.findAllByOrderByStartedOnDesc();
    }

    public Story viewChosenStory(Long id)
    {
        return storyRepository.findOne(id);
    }

    public List<Story> listOfFinishedStories()
    {
        return storyRepository.findAllByActiveFalseOrderByStartedOnDesc();
    }

    public Story save(Story story)
    {
        return storyRepository.save(story);
    }

    @Autowired
    @Required
    public void setStoryRepository(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }
}
