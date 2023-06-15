package com.almanackHotel.controller;

import com.almanackHotel.entity.Admin;
import com.almanackHotel.payload.JwtAuthenticationResponse;
import com.almanackHotel.payload.SigninDto;
import com.almanackHotel.repository.AdminDao;
import com.almanackHotel.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/almanack")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminDao adminDao;

    @PostMapping("/admin/login")
    public ResponseEntity<JwtAuthenticationResponse> getLoggedInAdminDetailsHandler(@RequestBody SigninDto signinDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signinDto.getUsernameOrEmail(),signinDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        // get token form tokenProvider
        String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

}
