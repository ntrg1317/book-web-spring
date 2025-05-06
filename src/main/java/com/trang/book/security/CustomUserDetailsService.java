package com.trang.book.security;

import com.trang.book.entity.Role;
import com.trang.book.entity.User;
import com.trang.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            System.out.println("User: " + user.getEmail());
            System.out.println("Roles: " + user.getRoles().stream().map(Role::getName).toList());
            System.out.println("Authorities: " + mapRolesToAuthorities(user.getRoles()));

            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles())
                    );
        } else {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> {
                    System.out.println("Mapping role: " + role.getName());
                    return new SimpleGrantedAuthority("ROLE_" + role.getName());
                })
                .collect(Collectors.toList());
        return mapRoles;
    }
}
