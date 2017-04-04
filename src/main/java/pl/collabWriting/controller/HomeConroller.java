package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.collabWriting.service.PostService;
import pl.collabWriting.service.StoryService;

/**
 * @author kattie95
 */

@Controller
public class HomeConroller
{
    private PostService postService;
    private StoryService storyService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("story", storyService.showNewestStory());
        model.addAttribute("post", postService.getLastUpdatedPost());
        return "index";
    }

    @RequestMapping("/sign")
    public String aboutSign()
    {
        return "user/aboutSign";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "user/login";
    }

}
