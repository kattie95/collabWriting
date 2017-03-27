package pl.collabWriting.service;

import org.junit.Test;
import pl.collabWriting.domain.User;
import pl.collabWriting.repository.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author kattie95
 */
public class UserServiceImplTest
{
    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void findByUsername() throws Exception
    {
        String username = "username";
        User user1 = mock(User.class);
        UserRepository userRepository = mock(UserRepository.class);
        userService.setUserRepository(userRepository);
        when(userRepository.findByUsername(username))
                .thenReturn(user1);

        User result = userService.findByUsername(username);

        assertEquals(user1, result);
        verify(userRepository).findByUsername(username);
    }

    @Test
    public void loadUserByUsername() throws Exception
    {
        //hmm...
    }

}