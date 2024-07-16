package com.br.api.sawagger.controller;

import com.br.api.sawagger.dtos.request.UserRequestDto;
import com.br.api.sawagger.dtos.response.UserDetailsResponseDto;
import com.br.api.sawagger.dtos.response.UserIdResponseDto;
import com.br.api.sawagger.entity.user.User;
import com.br.api.sawagger.entity.user.exception.NullFieldException;
import com.br.api.sawagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserIdResponseDto> createNewUser(@RequestBody UserRequestDto body) {
        if (body.login() == null)
            throw new NullFieldException("login");
        if (body.password() == null)
            throw new NullFieldException("password");
        User user = new User(body);
        this.userService.createUser(user);
        return ResponseEntity.ok().body(new UserIdResponseDto(user.getId()));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsResponseDto>> getAllUser(){
        List<UserDetailsResponseDto> users = this.userService.findAllUser();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDto> getUserById(@PathVariable Integer id){
        UserDetailsResponseDto userDetailsResponseDto = this.userService.findUserById(id);
        return ResponseEntity.ok().body(userDetailsResponseDto);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<List<UserDetailsResponseDto>> getUserByLogin(@PathVariable String login){
        List<UserDetailsResponseDto> userDetailsResponseDto = this.userService.findUserByLogin(login);
        return ResponseEntity.ok().body(userDetailsResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDto> deleteUser(@PathVariable Integer id){
        UserDetailsResponseDto userDetailsResponseDto = this.userService.findUserById(id);
        this.userService.deleteUser(id);
        return ResponseEntity.ok().body(userDetailsResponseDto);
    }
}
