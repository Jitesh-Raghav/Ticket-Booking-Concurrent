package com.example.ticketbookingconcurrent.Controller;

import com.example.ticketbookingconcurrent.Dtos.BookMovieShowRequestDTO;
import com.example.ticketbookingconcurrent.Dtos.BookMovieShowResponseDTO;
import com.example.ticketbookingconcurrent.Entity.Booking;
import com.example.ticketbookingconcurrent.Service.BookingService;
import com.example.ticketbookingconcurrent.enums.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieShowResponseDTO bookTicket(BookMovieShowRequestDTO requestDTO) {
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
