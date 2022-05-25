package br.com.victorcaselli.frameworkchallenge.services;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.repositories.UserRepository;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;

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
        User user = userRepository.save(getBasicUser().toEntity());
        existingId = user.getId();
    }

    @Test
    public void uerShouldSaveWhenReceiveData(){
        User user = userService.save(getBasicUser()).toEntity();
        assertNotNull(user.getId());
    }


    @Test
    public void userShouldThrowsExceptionWhenIdNotFound(){
        assertThrows(UserNotFoundException.class, () -> userService.findById(nonExistingId));
    }

    @Test
    public void userShouldGetCorrectUserWhenIdIsFound(){
        assertNotNull(userService.findById(existingId));
    }

    //TODO - Create a test to pageable list
    @Test
    public void userShouldGetNonEmptyListWhileFindAll(){
        assertFalse(userService.findAll().isEmpty());
    }

    @Test
    public void userShouldDeleteWhenDeleteServiceWasCalled(){
        long total = userRepository.count();

        userService.deleteById(existingId);

        assertTrue(userRepository.count() < total);
    }

    @Test
    public void userShouldThrowsExceptionWhenDeleteServiceWasCalledWithNonExistingId(){
        assertThrows(UserNotFoundException.class, () -> userService.deleteById(nonExistingId));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    public void userShouldUpdatedWhenUpdateServiceWasCalled(){
        String updateInformation = "John D. Undefined";

        User user = userRepository.findById(existingId).get();

        user.setFullName(updateInformation);

        user = userRepository.save(user);

        assertEquals(user.getFullName(),updateInformation);
    }
}
