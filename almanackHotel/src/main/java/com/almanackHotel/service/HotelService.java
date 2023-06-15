package com.almanackHotel.service;

import com.almanackHotel.entity.Hotel;
import com.almanackHotel.payload.HotelDTO;

public interface HotelService {
    public Hotel registerHotel(HotelDTO hotelRequest);
}
