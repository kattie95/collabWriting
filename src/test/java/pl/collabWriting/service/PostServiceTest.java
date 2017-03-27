package pl.collabWriting.service;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import pl.collabWriting.domain.Post;
import pl.collabWriting.repository.PostRepository;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author kattie95
 */
public class PostServiceTest {

    private PostService postService = new PostService();

    @Test
    public void listByStoryId() throws Exception
    {
        Long storyId = 1L;

        Post post1 = mock(Post.class);
        Post post2 = mock(Post.class);
        Post post3 = mock(Post.class);
        List<Post> posts = ImmutableList.of(post1, post2, post3);

        PostRepository postRepository = mock(PostRepository.class);
        postService.setPostRepository(postRepository);
        when(postRepository.findAllByStoryIdOrderByPostedOnAsc(storyId))
                .thenReturn(posts);

        List<Post> result = postService.listByStoryId(storyId);

        assertEquals(posts, result);
        verify(postRepository).findAllByStoryIdOrderByPostedOnAsc(storyId);
    }

    @Test
    public void viewChosenPost() throws Exception
    {
        Long postId = 1L;
        Post post1 = mock(Post.class);

        PostRepository postRepository = mock(PostRepository.class);
        postService.setPostRepository(postRepository);
        when(postRepository.findOne(postId))
                .thenReturn(post1);

        Post result = postService.viewChosenPost(postId);

        assertEquals(post1, result);
        verify(postRepository).findOne(postId);
    }

    @Test
    public void getLastUpdatedPost() throws Exception
    {
        Post post1 = mock(Post.class);

        PostRepository postRepository = mock(PostRepository.class);
        postService.setPostRepository(postRepository);
        when(postRepository.findFirstByOrderByPostedOnDesc())
                .thenReturn(post1);

        Post result = postService.getLastUpdatedPost();

        assertEquals(post1, result);
        verify(postRepository).findFirstByOrderByPostedOnDesc();
    }

    @Test
    public void listByLastUpdatedPosts() throws Exception
    {
        Post post1 = mock(Post.class);
        Post post2 = mock(Post.class);
        Post post3 = mock(Post.class);
        List<Post> posts = ImmutableList.of(post1, post2, post3);

        PostRepository postRepository = mock(PostRepository.class);
        postService.setPostRepository(postRepository);
        when(postRepository.findAllByOrderByPostedOnDesc())
                .thenReturn(posts);

        List<Post> result = postService.listByLastUpdatedPosts();

        assertEquals(posts, result);
        verify(postRepository).findAllByOrderByPostedOnDesc();
    }

    @Test
    public void save() throws Exception
    {
        //metoda, która ma zapisywać, aczkolwiek - jeszcze mi nie działa
    }

}