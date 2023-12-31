package com.almanackHotel.repository;

import com.almanackHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelDao extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findByHotelEmail(String email);

    @Modifying
    @Query("update Hotel set hotelEmail=?2 where hotelId=?1")
    Integer setEmailOfHotel(Long id, String email);

    @Modifying
    @Query("update Hotel set hotelPhone=?2 where hotelId=?1")
    Integer setPhoneOfHotel(Long id, String phone);

    @Modifying
    @Query("update Hotel set hotelTelephone=?2 where hotelId=?1")
    Integer setTelephoneOfHotel(Long id, String telephone);

    @Modifying
    @Query("update Hotel set name=?2 where hotelId=?1")
    Integer setNameOfHotel(Long id, String name);

    /*Overridden equals and hash code on city field*/



}
