package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.collabWriting.service.CommentService;
import pl.collabWriting.service.PostService;

/**
 * @author kattie95
 */

@Controller
public class CommentController
{
    private CommentService commentService;
    private PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @RequestMapping("/stories/comments/{id}")
    public String readComments(@PathVariable(value = "id")Long id,Model model)
    {
        model.addAttribute("post",postService.viewChosenPost(id));
        model.addAttribute("comments",commentService.showComments(id));
        return "story/comments/viewComments";
    }

}
