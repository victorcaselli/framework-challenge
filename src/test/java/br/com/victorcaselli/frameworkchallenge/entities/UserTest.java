package br.com.victorcaselli.frameworkchallenge.entities;

import br.com.victorcaselli.frameworkchallenge.factory.UserFactory;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class UserTest {


    //TODO - Change to controllers tests
//    @Test
//    public void userShouldThrowsExceptionWhenEmailOrPasswordWereNotFound(){
//        assertThrows(UserValidationException.class, UserFactory::getUserWithoutEmailAndPassword);
//    }
//
//    @Test
//    public void userShouldThrowsExceptionWhenPasswordLessThanSix(){
//        assertThrows(UserValidationException.class, UserFactory::getUserWithInvalidPassword);
//    }
}
