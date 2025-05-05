package com.trang.book.controller;

import com.trang.book.dto.UserDto;
import com.trang.book.entity.User;
import com.trang.book.security.RedirectUtil;
import com.trang.book.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello!");
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "auth/register";
    }

    @PostMapping("/register/save")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult result,
                           Model model) {
        User existUser = userService.findByEmail(userDto.getEmail());
        if (existUser != null) {
            result.rejectValue("email", null, "There is already a user registered with that email");
        }

        if (result.hasErrors()) {
            result.getAllErrors().forEach(System.out::println);
            model.addAttribute("user", userDto);
            return "auth/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
}
