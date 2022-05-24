package br.com.victorcaselli.frameworkchallenge.services.exceptions;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 8938965278523274096L;

    public UserNotFoundException(String message){
        super(message);
    }
}
