package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> showComments(Long id)
    {
        return commentRepository.findAllByPostIdOrderByCommentedOnDesc(id);
    }

    public Comment save (Comment comment)
    {
        return commentRepository.save(comment);
    }
}
