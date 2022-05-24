package br.com.victorcaselli.frameworkchallenge.factory;


import br.com.victorcaselli.frameworkchallenge.dto.request.UserDtoRequest;
import br.com.victorcaselli.frameworkchallenge.entities.User;

import java.io.Serializable;

public class UserFactory {


    public static UserDtoRequest getBasicUser(){
        return UserDtoRequest.builder()
                .email("johndoe@xpto.com")
                .password("123_124V")
                .fullName("John Doe")
                .build();
    }

    public static UserDtoRequest getUserWithoutEmailAndPassword(){
        return UserDtoRequest.builder()
                .fullName("John Doe")
                .build();
    }

    public static UserDtoRequest getUserWithInvalidPassword(){
        return UserDtoRequest.builder()
                .email("johndoe@xpto.com")
                .password("123")
                .fullName("John Doe")
                .build();
    }

}
