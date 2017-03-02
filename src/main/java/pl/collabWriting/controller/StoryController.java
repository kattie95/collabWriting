package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.collabWriting.service.StoryService;

/**
 * @author kattie95
 */

@Controller
@RequestMapping("/stories")
public class StoryController
{
    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/list")
    public String listOfStories(Model model)
    {
        model.addAttribute("stories", storyService.list());
        return "story/listOfAllStories";
    }
}
