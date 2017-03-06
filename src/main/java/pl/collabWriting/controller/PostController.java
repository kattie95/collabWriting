package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.collabWriting.service.PostService;
import pl.collabWriting.service.StoryService;

/**
 * @author kattie95
 */
@Controller
public class PostController
{
    private PostService postService;
    private StoryService storyService;

    @Autowired
    public PostController(PostService postService, StoryService storyService) {
        this.postService = postService;
        this.storyService = storyService;
    }

    @RequestMapping("stories/view/{id}")
    public String viewChosenStory(@PathVariable(value = "id") Long id, Model model)
    {
        model.addAttribute("story",storyService.viewChosenStory(id));
        model.addAttribute("posts",postService.listByStoryId(id));
        return "story/viewChosenStory";
    }
}
