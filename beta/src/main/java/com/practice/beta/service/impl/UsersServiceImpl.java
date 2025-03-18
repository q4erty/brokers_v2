package com.practice.beta.service.impl;

import com.practice.beta.model.dto.UserDTO;
import com.practice.beta.model.entity.UserEntity;
import com.practice.beta.model.mapping.UserMapper;
import com.practice.beta.repository.UserRepository;
import com.practice.beta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity addUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toUser(userDTO);
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toUserDTO);
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("user nor found"));  //TODO new UserNotFoundException("Пользователь с ID " + id + " не найден")
        userEntity.setUsername(userDTO.username());
        userEntity.setEmail(userDTO.email());
        userEntity.setPassword(userDTO.password());
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
