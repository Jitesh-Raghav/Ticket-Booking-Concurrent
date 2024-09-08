package com.example.ticketbookingconcurrent.Repositories;

import com.example.ticketbookingconcurrent.Entity.Show;
import com.example.ticketbookingconcurrent.Entity.ShowSeat;
import com.example.ticketbookingconcurrent.Entity.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> ids);

    @Override
    ShowSeat save(ShowSeat showSeat);
}
