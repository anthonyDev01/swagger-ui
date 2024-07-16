package com.br.api.sawagger.config;

import com.br.api.sawagger.entity.user.exception.NullFieldException;
import com.br.api.sawagger.entity.user.exception.UserNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handlerUserNotFound(UserNotFoundException exception){
        String errorMessage = "Usuario não encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity handlerNullField(NullFieldException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
