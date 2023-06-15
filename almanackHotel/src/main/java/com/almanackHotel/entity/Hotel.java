package com.almanackHotel.entity;

import com.almanackHotel.enums.HotelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotelId;
    @NotNull
    @NotEmpty
    private String name;
    @Column(unique = true)
    @Email
    @NotNull
    private String hotelEmail;
    @NotNull
    @NotEmpty
    private String hotelPhone;
    @NotNull
    @NotEmpty
    private String hotelTelephone;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")
    @NotNull
    @NotEmpty
    private String password;
    private String role;

    @Enumerated(EnumType.STRING)
    private HotelType hotelType;

}
