package com.almanackHotel.controller;

import com.almanackHotel.entity.Admin;
import com.almanackHotel.security.JwtTokenProvider;
import com.almanackHotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;


@RestController
@RequestMapping("/almanack/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
        Admin res = adminService.registerAdmin(admin);
        return new ResponseEntity<Admin>(res, HttpStatus.CREATED);
    }
}
