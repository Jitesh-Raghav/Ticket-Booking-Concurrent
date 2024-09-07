package com.example.ticketbookingconcurrent.Dtos;

import com.example.ticketbookingconcurrent.enums.ResponseStatus;
import lombok.Data;

@Data
public class SignUpResponseDTO {
    private Long userId;
    private ResponseStatus responseStatus;
}
