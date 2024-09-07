package com.example.ticketbookingconcurrent.Repositories;

import com.example.ticketbookingconcurrent.Entity.Show;
import com.example.ticketbookingconcurrent.Entity.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatRepository, Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
