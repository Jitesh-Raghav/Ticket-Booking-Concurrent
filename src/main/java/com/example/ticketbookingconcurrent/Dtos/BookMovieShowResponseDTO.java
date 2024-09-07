package com.example.ticketbookingconcurrent.Dtos;

import com.example.ticketbookingconcurrent.enums.ResponseStatus;
import lombok.Data;

@Data
public class BookMovieShowResponseDTO {
    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}

