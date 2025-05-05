package com.trang.book.dto;

import com.trang.book.validation.annotation.PasswordMatches;
import com.trang.book.validation.annotation.ValidEmail;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class UserDto
{
    @NotNull
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotNull
    @NotEmpty(message = "Email should not be empty")
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotNull
    @NotEmpty(message = "Password confirmation should not be empty")
    private String confirmPassword;
}
