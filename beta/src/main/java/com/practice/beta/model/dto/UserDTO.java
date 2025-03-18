package com.practice.beta.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO
        (
                @NotBlank
                @Size(min = 3, max = 20)
                String username,

                @NotBlank
                @Size(min = 10, max = 50)
                String email,

                @NotBlank
                @Size(min = 6, max = 20)
                String password
        )
{}
