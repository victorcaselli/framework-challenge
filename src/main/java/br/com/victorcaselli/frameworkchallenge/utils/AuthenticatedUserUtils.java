package br.com.victorcaselli.frameworkchallenge.utils;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.services.UserService;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class AuthenticatedUserUtils {

    private final UserService userService;
    private static UserService staticUserService;


    @PostConstruct
    public void setup(){
       staticUserService = userService;
    }

    public static User getAuthUser(){
        return staticUserService.getAuthenticatedUser();
    }

}
