package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.collabWriting.domain.Story;
import pl.collabWriting.service.PostService;
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

    @RequestMapping("/newest")
    public String listOfStories(Model model)
    {
        model.addAttribute("stories", storyService.list());
        return "story/listOfAllStories";
    }

    @RequestMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("story", new Story());
        return "story/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Story story)
    {
        Story savedStory = storyService.save(story);
        return "redirect:/view/" + savedStory.getId(); //TODO coś do zmiany tu zapewne będzie
    }
//TODO dodać UserService itd, ustalić w dodawaniu wpisów, komentarzy, postów, żeby brało automatcznie userId użytkownika, który jest zalogowany.

}
