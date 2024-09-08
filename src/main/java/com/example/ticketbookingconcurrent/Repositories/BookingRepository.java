package com.example.ticketbookingconcurrent.Repositories;

import com.example.ticketbookingconcurrent.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Override
    Booking save(Booking booking);
}
