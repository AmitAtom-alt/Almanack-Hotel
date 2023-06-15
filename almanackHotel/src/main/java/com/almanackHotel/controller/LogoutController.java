package com.almanackHotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/almanack")
public class LogoutController {

    @PostMapping("/admin/logout")
    public ResponseEntity<String> adminLogoutHandler(Authentication authentication) {
        return performLogout(authentication);
    }

    private ResponseEntity<String> performLogout(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            // If user is not authenticated, return an error response
            return new ResponseEntity<>("You are not logged in", HttpStatus.UNAUTHORIZED);
        }

        // Clear the authentication from SecurityContextHolder
        SecurityContextHolder.clearContext();

        return new ResponseEntity<>("You have been logged out", HttpStatus.OK);
    }
}
