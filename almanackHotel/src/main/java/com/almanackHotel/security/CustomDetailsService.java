package com.almanackHotel.security;

import com.almanackHotel.entity.Admin;
import com.almanackHotel.repository.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> adminOptional = adminDao.findByEmail(username);

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(admin.getRole().toString());
            authorities.add(sga);
            return new User(admin.getEmail(), admin.getPassword(), authorities);

        }
        return null;
    }
}
