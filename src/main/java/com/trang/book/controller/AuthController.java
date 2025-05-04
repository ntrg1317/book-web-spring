package com.trang.book.controller;

import com.trang.book.security.RedirectUtil;
import com.trang.book.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
//    @GetMapping("/")
//    public String homePage(Authentication authentication) {
//        String redirect = getAuthenticatedUserRedirectUrl(authentication);
//        if (redirect != null) return redirect;
//        return "index";
//    }
//    private String getAuthenticatedUserRedirectUrl(Authentication authentication) {
//        if (authentication != null && authentication.isAuthenticated()) {
//            String redirectUrl = RedirectUtil.getRedirectUrl(authentication);
//            if (redirectUrl != null) {
//                return "redirect:" + redirectUrl;
//            }
//        }
//        return null;
//    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello!");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
