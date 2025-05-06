package com.trang.book.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class RedirectUtil {
    public static String getRedirectUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_admin")) {
                return "/admin/book";
            } else if (grantedAuthority.getAuthority().equals("ROLE_user")) {
                return "/book";
            }
        }
        return null;
    }
}
