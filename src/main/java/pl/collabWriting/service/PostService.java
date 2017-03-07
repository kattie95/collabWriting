package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> listByStoryId(Long id)
    {
        return postRepository.findAllByStoryIdOrderByPostedOnAsc(id);
    }

    public Post viewChosenPost(Long id)
    {
        return postRepository.findOne(id);
    }
}
