package com.example.ticketbookingconcurrent.Controller;

import com.example.ticketbookingconcurrent.Dtos.BookMovieShowRequestDTO;
import com.example.ticketbookingconcurrent.Dtos.BookMovieShowResponseDTO;
import com.example.ticketbookingconcurrent.Entity.Booking;
import com.example.ticketbookingconcurrent.Service.BookingService;
import com.example.ticketbookingconcurrent.enums.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ticket")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public BookMovieShowResponseDTO bookTicket(@RequestBody BookMovieShowRequestDTO requestDTO) {
        BookMovieShowResponseDTO responseDTO = new BookMovieShowResponseDTO();
        try {
            Booking booking = bookingService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatIds());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
