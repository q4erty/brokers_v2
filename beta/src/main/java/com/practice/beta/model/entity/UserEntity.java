package com.practice.beta.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(min = 10, max = 50)
    private String email;

    @NotBlank
    @Column(name = "password", unique = true, nullable = false)
    @Size(min = 6, max = 20)
    private String password;

    @Column(name = "enabled")
    private boolean enabled = false;
}
