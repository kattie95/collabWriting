package pl.collabWriting.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author kattie95
 */

@Entity
@Table (name = "users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    @Column (unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    private String fullName;
    private String email;
    private String description;

    @OneToMany
    private List<Story> stories;

    @OneToMany
    private List<Post> posts;

    private User()
    {
        //
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
