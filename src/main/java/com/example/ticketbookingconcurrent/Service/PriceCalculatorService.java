package com.example.ticketbookingconcurrent.Service;

import com.example.ticketbookingconcurrent.Entity.Show;
import com.example.ticketbookingconcurrent.Entity.ShowSeat;
import com.example.ticketbookingconcurrent.Entity.ShowSeatType;
import com.example.ticketbookingconcurrent.Repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculatePrice(Show show, List<ShowSeat> showSeats) {
        double amount = 0d;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
