package com.almanackHotel.service.impl;

import com.almanackHotel.entity.Hotel;
import com.almanackHotel.payload.HotelDTO;
import com.almanackHotel.repository.HotelDao;
import com.almanackHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;
    @Override
    public Hotel registerHotel(HotelDTO hotelRequest) {
        return null;
    }
}
