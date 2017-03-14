package pl.collabWriting.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kattie95
 */

@Entity
@Table (name = "roles")
public class Role
{
    @Id
    @GeneratedValue
    private Long id;

    private String role;
    private boolean makeStory;
    private boolean makePost;

    @OneToMany (mappedBy = "role")
    private Set<User> users;

    private Role()
    {
        //
    }

    public Role(String role, boolean makeStory, boolean makePost) {
        this.role = role;
        this.makeStory = makeStory;
        this.makePost = makePost;
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isMakeStory() {
        return makeStory;
    }

    public void setMakeStory(boolean makeStory) {
        this.makeStory = makeStory;
    }

    public boolean isMakePost() {
        return makePost;
    }

    public void setMakePost(boolean makePost) {
        this.makePost = makePost;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
