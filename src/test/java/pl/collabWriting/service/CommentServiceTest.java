package pl.collabWriting.service;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import pl.collabWriting.domain.Comment;
import pl.collabWriting.repository.CommentRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author kattie95
 */
public class CommentServiceTest
{

    private CommentService commentService = new CommentService();

    @Test
    public void showComments() throws Exception
    {
        Long postId = 1L;
        Comment comment1 = mock(Comment.class);
        Comment comment2 = mock(Comment.class);
        Comment comment3 = mock(Comment.class);
        List<Comment> comments = ImmutableList.of(comment1, comment2, comment3);

        CommentRepository commentRepository = mock(CommentRepository.class);
        commentService.setCommentRepository(commentRepository);
        when(commentRepository.findAllByPostIdOrderByCommentedOnDesc(postId))
                .thenReturn(comments);

        List<Comment> result = commentService.showComments(postId);

        assertEquals(comments, result);
        verify(commentRepository).findAllByPostIdOrderByCommentedOnDesc(postId);
    }

    @Test
    public void save() throws Exception
    {
        //
    }

}