package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.collabWriting.domain.Story;
import pl.collabWriting.service.PostService;
import pl.collabWriting.service.StoryService;
import pl.collabWriting.service.UserServiceImpl;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kattie95
 */

@Controller
@RequestMapping("/stories")
public class StoryController
{
    private StoryService storyService;
    private PostService postService;
    private UserServiceImpl userService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/newest")
    public String listOfStories(Model model)
    {
        model.addAttribute("stories", storyService.list());
        return "story/listOfAllStories";
    }

    @RequestMapping("/updated")
    public String latestUpdates(Model model)
    {
        model.addAttribute("posts", postService.listByLastUpdatedPosts());
        return "story/lastUpdated";
    }

    @RequestMapping("/finished")
    public String finished(Model model)
    {
        model.addAttribute("stories",storyService.listOfFinishedStories());
       // model.addAttribute("post", postService.getLastUpdatedPost()); todo make it show last Post of proper Story
        return "story/finishedStories";
    }

    @Secured({"ROLE_ADMIN", "ROLE_WRITER"})
    @RequestMapping(value = "/create") //todo check if that get method is necessary
    public String create(Model model)
    {
        model.addAttribute("currentUser", userService.showCurrentUser());
        model.addAttribute("story", new Story());
        return "story/createStory";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Story story)
    {
        Calendar calendar = Calendar.getInstance();
        Date currentDate=calendar.getTime();

        story.setUser(userService.showCurrentUser());
        story.setStartedOn(currentDate);
        story.setActive(true);
        Story savedStory = storyService.save(story);
        return "redirect:/newest"; // + savedStory.getId();      //todo poprawić redirect
    }
}
