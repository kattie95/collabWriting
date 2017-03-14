package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.collabWriting.service.PostService;

/**
 * @author kattie95
 */

@Controller
public class HomeConroller
{
    private PostService postService;

    @Autowired
    public HomeConroller(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/")
    public String home(Model model)
    {
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
