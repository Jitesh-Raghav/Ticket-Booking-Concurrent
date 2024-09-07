package com.example.ticketbookingconcurrent.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name="users")
@Data
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    private String contact;
    //User : Booking
    //1 : M
    //1 : 1
    @OneToMany
    private List<Booking> bookings;
}
