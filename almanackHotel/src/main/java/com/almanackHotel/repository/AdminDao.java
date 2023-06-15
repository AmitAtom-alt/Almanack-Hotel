package com.almanackHotel.repository;

import com.almanackHotel.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);
}
