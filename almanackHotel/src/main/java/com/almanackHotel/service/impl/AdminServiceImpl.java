package com.almanackHotel.service.impl;

import com.almanackHotel.entity.Admin;
import com.almanackHotel.exceptions.AdminException;
import com.almanackHotel.repository.AdminDao;
import com.almanackHotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin registerAdmin(Admin admin) {
        Optional<Admin> adminExist = adminDao.findByEmail(admin.getEmail());

        if(adminExist.isPresent()){
            throw new AdminException("Admin already exists");
        }
        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);

        return adminDao.save(admin);
    }
}
