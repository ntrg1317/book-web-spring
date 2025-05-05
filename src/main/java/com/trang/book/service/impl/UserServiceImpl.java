package com.trang.book.service.impl;

import com.trang.book.dto.UserDto;
import com.trang.book.entity.User;
import com.trang.book.repository.UserRepository;
import com.trang.book.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {

    }
}
