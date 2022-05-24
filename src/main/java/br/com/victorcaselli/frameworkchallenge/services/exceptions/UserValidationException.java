package br.com.victorcaselli.frameworkchallenge.services.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserValidationException extends RuntimeException{
    private static final long serialVersionUID = -3287351888666172945L;

    public UserValidationException(String message){
        super(message);
    }
}
