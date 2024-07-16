package com.br.api.sawagger.service;

import com.br.api.sawagger.dtos.request.UserRequestDto;
import com.br.api.sawagger.dtos.response.UserDetailsResponseDto;
import com.br.api.sawagger.entity.user.User;
import com.br.api.sawagger.entity.user.exception.UserNotFoundException;
import com.br.api.sawagger.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User body){
        return this.userRepository.save(body);
    }

    public List<UserDetailsResponseDto> findAllUser(){
        List<User> users =  this.userRepository.findAll();
        return users.stream().map(user -> new UserDetailsResponseDto(user.getLogin(), user.getPassword())).toList();
    }

    public UserDetailsResponseDto findUserById(Integer id){
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado"));
        return new UserDetailsResponseDto(user.getLogin(), user.getPassword());
    }

    public List<UserDetailsResponseDto> findUserByLogin(String login){
        List<User> users = this.userRepository.findByLogin(login);
        return users.stream().map(user -> new UserDetailsResponseDto(user.getLogin(), user.getPassword())).toList();
    }

    public void deleteUser(Integer id){
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado"));
        this.userRepository.delete(user);
    }

}
