package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.collabWriting.domain.Post;
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
        model.addAttribute("post", new Post());
        return "story/viewChosenStory";
    }

    @RequestMapping(value = "stories/view/save", method = RequestMethod.POST)
    public String save(Post post)
    {
        Post savedPost = postService.save(post);
        return "redirect:stories/view/" + savedPost.getStory().getId(); //TODO uzupełnić szkic
    }
}
