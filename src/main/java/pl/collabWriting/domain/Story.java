package pl.collabWriting.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author kattie95
 */
@Entity
@Table (name = "stories")
public class Story
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String title;
    private String description;

    //TODO wymyśleć tagi - żeby z góry można określić kierunek historii i sortować, jeśli ktoś chce tylko w danym kierunku pisać... tag.

    @CreatedDate
    private Date startedOn;

    private boolean active;
    private boolean allowWriters;
    private boolean allowCollabs;

    @OneToMany (mappedBy = "story")
    private List<Post> posts;

    @SuppressWarnings("unused")
    public Story()
    {
        //
    }
/*
    public Story(Long id, User user, String title) {
        this.id = id;
        this.user = user;
        this.title = title;
        }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Date startedOn) {
        this.startedOn = startedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAllowWriters() {
        return allowWriters;
    }

    public void setAllowWriters(boolean allowWriters) {
        this.allowWriters = allowWriters;
    }

    public boolean isAllowCollabs() {
        return allowCollabs;
    }

    public void setAllowCollabs(boolean allowCollabs) {
        this.allowCollabs = allowCollabs;
    }
}
