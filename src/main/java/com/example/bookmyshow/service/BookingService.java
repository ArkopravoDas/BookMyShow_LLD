package com.example.bookmyshow.service;

import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.repository.BookingRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    BookingRepository bookingRepository;
    ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking bookTicket(List<Long> showSeatList) {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatList);

        if(showSeats.size() == 0) {
            System.out.println("Invalid show seats");
        }

        System.out.println(showSeats.get(0));

        return null;
    }
}
