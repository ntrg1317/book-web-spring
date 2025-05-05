package com.trang.book.dto;

import com.trang.book.validation.annotation.PasswordMatches;
import com.trang.book.validation.annotation.ValidEmail;


import jakarta.validation.constraints.*;

import lombok.*;
import org.aspectj.bridge.IMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class UserDto
{
    @NotBlank(message = "Name should not be empty")
    private String name;

    @NotBlank(message = "Email should not be empty")
    @ValidEmail
    private String email;

    @NotBlank(message = "Password should not be empty")
    private String password;

    @NotBlank(message = "Password confirmation should not be empty")
    private String confirmPassword;
}
