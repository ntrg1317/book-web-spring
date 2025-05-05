package com.trang.book.service.impl;

import com.trang.book.dto.UserDto;
import com.trang.book.entity.Role;
import com.trang.book.entity.User;
import com.trang.book.repository.RoleRepository;
import com.trang.book.repository.UserRepository;
import com.trang.book.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findRoleByName("user");
        if (role == null) {
            role = createRoleIfNotExist();
        }

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role createRoleIfNotExist() {
        Role role = new Role();
        role.setName("user");
        return roleRepository.save(role);
    }
}
