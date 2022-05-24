package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.victorcaselli.frameworkchallenge.factory.UserFactory.getBasicUser;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private final Long nonExistingId = 234L;
    private Long existingId;

    @BeforeEach
    void setupAll(){
        User user = userRepository.save(getBasicUser());
        existingId = user.getId();
    }

    @Test
    public void uerShouldSaveWhenReceiveData(){
        User user = getBasicUser().toEntity();
        user = userService.save(user);
        assertNotNull(user.getId());
    }


    @Test
    public void userShouldThrowsExceptionWhenIdNotFound(){
        assertThrows(UserNotFoundException.class, () -> userService.findById(nonExistingId));
    }

    @Test
    public void userShouldGetCorrectUserWhenIdIsFound(){
        assertNotNull(userService.findById(existingId).get());
    }

    //TODO - Create a test to pageable list
    @Test
    public void userShouldGetNonEmptyListWhileFindAll(){
        assertTrue(!userService.findAll().isEmpty());
    }

    @Test
    public void userShouldDeleteWhenDeleteServiceWasCalled(){
        Long total = userRepository.count();

        userService.deleteById(existingId);

        assertTrue(userRepository.count() < total);
    }

    @Test
    public void userShouldThrowsExceptionWhenDeleteServiceWasCalledWithNonExistingId(){
        assertThrows(UserNotFoundException.class, () -> userService.deleteById(nonExistingId));
    }

    @Test
    public void userShouldUpdatedWhenUpdateServiceWasCalled(){
        String updateInformation = "John D. Undefined";

        User user = userRepository.findById(existingId).get();

        user.setFullName(updateInformation);

        user = userRepository.save(user);

        assertEquals(user.getFullName().equals(updateInformation));
    }
}
