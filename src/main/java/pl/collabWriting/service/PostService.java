package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import pl.collabWriting.domain.Post;
import pl.collabWriting.repository.PostRepository;

import java.util.List;

/**
 * @author kattie95
 */

@Service
public class PostService
{
    private PostRepository postRepository;

    public List<Post> listByStoryId(Long id)
    {
        return postRepository.findAllByStoryIdOrderByPostedOnAsc(id);
    }

    public Post viewChosenPost(Long id)
    {
        return postRepository.findOne(id);
    }

    public Post getLastUpdatedPost()
    {
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<Post> listByLastUpdatedPosts()
    {
        return postRepository.findAllByOrderByPostedOnDesc();
    }

    public Post save (Post post){
        return postRepository.save(post);
    }

    @Autowired
    @Required
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
