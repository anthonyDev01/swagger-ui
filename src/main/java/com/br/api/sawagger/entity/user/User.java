package com.br.api.sawagger.entity.user;

import com.br.api.sawagger.dtos.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;

    public User(UserRequestDto data) {
        this.login = data.login();
        this.password = data.password();
    }
}
