package com.br.api.sawagger.entity.user.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String menssage){
        super(menssage);
    }

}
