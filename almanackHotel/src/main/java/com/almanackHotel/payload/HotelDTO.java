package com.almanackHotel.payload;

import com.almanackHotel.enums.HotelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
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




    @Enumerated(EnumType.STRING)
    private HotelType hotelType;
}
