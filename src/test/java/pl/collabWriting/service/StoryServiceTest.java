package pl.collabWriting.service;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import pl.collabWriting.domain.Story;
import pl.collabWriting.repository.StoryRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author kattie95
 */
public class StoryServiceTest
{
    private StoryService storyService = new StoryService();

    @Test
    public void list() throws Exception
    {
        Story story1 = mock(Story.class);
        Story story2 = mock(Story.class);
        Story story3 = mock(Story.class);
        List<Story> stories = ImmutableList.of(story1, story2, story3);

        StoryRepository storyRepository = mock(StoryRepository.class);
        storyService.setStoryRepository(storyRepository);
        when(storyRepository.findAllByOrderByStartedOnDesc())
                .thenReturn(stories);

        List<Story> result = storyService.list();

        assertEquals(stories, result);
        verify(storyRepository).findAllByOrderByStartedOnDesc();
    }

    @Test
    public void viewChosenStory() throws Exception
    {
        Long storyId = 1L;
        Story story1 = mock(Story.class);

        StoryRepository storyRepository = mock(StoryRepository.class);
        storyService.setStoryRepository(storyRepository);
        when(storyRepository.findOne(storyId))
                .thenReturn(story1);

        Story result = storyService.viewChosenStory(storyId);

        assertEquals(story1, result);
        verify(storyRepository).findOne(storyId);
    }

    @Test
    public void listOfFinishedStories() throws Exception
    {
        Story story1 = mock(Story.class);
        Story story2 = mock(Story.class);
        Story story3 = mock(Story.class);
        List<Story> stories = ImmutableList.of(story1, story2, story3);

        StoryRepository storyRepository = mock(StoryRepository.class);
        storyService.setStoryRepository(storyRepository);
        when(storyRepository.findAllByActiveFalseOrderByStartedOnDesc())
                .thenReturn(stories);

        List<Story> result = storyService.listOfFinishedStories();

        assertEquals(stories, result);
        verify(storyRepository).findAllByActiveFalseOrderByStartedOnDesc();
    }

    @Test
    public void save() throws Exception
    {
        //
    }

}