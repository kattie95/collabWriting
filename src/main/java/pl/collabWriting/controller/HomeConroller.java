package pl.collabWriting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kattie95
 */

@Controller
public class HomeConroller
{
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }
}
