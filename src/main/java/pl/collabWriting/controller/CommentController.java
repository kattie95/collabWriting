package pl.collabWriting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.collabWriting.domain.Comment;
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
        model.addAttribute("comment", new Comment());
        return "story/comments/viewComments";
    }

    @RequestMapping("stories/comments/create") //todo dodać to jako guzik przy konkretnym poście - ma zejść collapse możliwość dodania postu
    public String create(Model model)
    {
        model.addAttribute("comment", new Comment());
        return "story/comments/create";
    }

    @RequestMapping(value = "stories/comments/save", method = RequestMethod.POST)
    public String save(Comment comment)
    {
        Comment savedComment = commentService.save(comment);
        return "redirect:stories/comments/" + savedComment.getPost().getId(); //TODO coś do zmiany tu zapewne będzie
    }

}