package pl.collabWriting.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.collabWriting.domain.Role;
import pl.collabWriting.domain.User;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kattie95
 */

public class UserDetailsImpl implements UserDetails
{
    private User user;
    public UserDetailsImpl(User user)
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Role userRole = user.getRole();
        authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        return authorities;
    }

    public User getUser()
    {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
