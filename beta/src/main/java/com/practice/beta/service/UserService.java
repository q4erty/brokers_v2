package com.practice.beta.service;

import com.practice.beta.model.dto.UserDTO;
import com.practice.beta.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAll();

    UserEntity addUser(UserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    void updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
