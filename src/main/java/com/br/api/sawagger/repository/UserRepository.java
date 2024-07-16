package com.br.api.sawagger.repository;

import com.br.api.sawagger.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByLogin(String login);
}
