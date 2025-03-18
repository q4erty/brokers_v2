package com.practice.beta.controller;

import com.practice.beta.model.dto.UserDTO;
import com.practice.beta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{id:\\d+}")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Optional<UserDTO> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PatchMapping
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
