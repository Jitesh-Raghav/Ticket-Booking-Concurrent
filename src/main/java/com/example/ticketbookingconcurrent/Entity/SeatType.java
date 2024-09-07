package com.example.ticketbookingconcurrent.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name="seat_types")
@Data
public class SeatType extends BaseModel{
    private String name;
}
