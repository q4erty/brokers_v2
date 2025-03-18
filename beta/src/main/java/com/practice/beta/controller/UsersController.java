package com.practice.beta.controller;

import com.practice.beta.model.dto.UserDTO;
import com.practice.beta.model.entity.UserEntity;
import com.practice.beta.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;
    private final MessageSource messageSource;

    @GetMapping
    public List<UserEntity> getUsers(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDto,
                                     BindingResult bindingResult, Locale locale) {
        if (bindingResult.hasErrors()) {
            String errorMessages = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest()
                    .body(this.messageSource
                            .getMessage("error.400.registration" + errorMessages, new Object[0], "Registration problems: " + errorMessages, locale));
        }
        userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.messageSource
                .getMessage("success.201.registration", new Object[0], "User registered successfully", locale));

    }
}
