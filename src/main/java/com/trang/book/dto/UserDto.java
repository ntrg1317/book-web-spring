package com.trang.book.dto;

import lombok.*;
//import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
}
