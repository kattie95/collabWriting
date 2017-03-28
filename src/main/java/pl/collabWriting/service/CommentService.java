package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import pl.collabWriting.domain.Comment;
import pl.collabWriting.repository.CommentRepository;

import java.util.List;

/**
 * @author kattie95
 */

@Service
public class CommentService
{
    private CommentRepository commentRepository;

    public List<Comment> showComments(Long postId)
    {
        return commentRepository.findAllByPostIdOrderByCommentedOnDesc(postId);
    }

    public Comment save (Comment comment)
    {
        return commentRepository.save(comment);
    }

    @Autowired
    @Required
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}
