package com.br.api.sawagger.entity.user.exception;

public class NullFieldException extends RuntimeException{
    public NullFieldException(String message){
        super("O campo " + message + " não pode ser vazio!");
    }
}
