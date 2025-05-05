package com.trang.book.service;

import com.trang.book.dto.UserDto;
import com.trang.book.entity.User;


public interface UserService {
    User findByEmail(String email);

    void saveUser(UserDto userDto);
}
