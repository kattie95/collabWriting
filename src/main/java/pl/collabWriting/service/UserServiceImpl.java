package pl.collabWriting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.collabWriting.domain.User;
import pl.collabWriting.repository.UserRepository;

/**
 * @author kattie95
 */

@Service
public class UserServiceImpl implements UserDetailsService
{
    private UserRepository userRepository;

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User showCurrentUser()
    {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User currentUser = userDetailsImpl.getUser();
        return currentUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = findByUsername(username);    //to samo(?) -> userRepositry.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException(username);

        }
        return new UserDetailsImpl(user);
    }
    //todo dodać jeszcze exception w przypadku błędnego hasła - zastanowić się

    @Autowired
    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
