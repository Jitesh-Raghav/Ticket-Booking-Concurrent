package com.example.ticketbookingconcurrent.Service;

import com.example.ticketbookingconcurrent.Entity.Booking;
import com.example.ticketbookingconcurrent.Entity.Show;
import com.example.ticketbookingconcurrent.Entity.ShowSeat;
import com.example.ticketbookingconcurrent.Entity.User;
import com.example.ticketbookingconcurrent.Exceptions.SeatNotEmptyException;
import com.example.ticketbookingconcurrent.Exceptions.ShowNotFoundException;
import com.example.ticketbookingconcurrent.Exceptions.UserNotFoundException;
import com.example.ticketbookingconcurrent.Repositories.*;
import com.example.ticketbookingconcurrent.enums.BookingStatus;
import com.example.ticketbookingconcurrent.enums.ShowSeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public BookingService(UserRepository userRepository,
                             BookingRepository bookingRepository,
                             ShowSeatRepository showSeatRepository,
                             ShowRepository showRepository,
                             ShowSeatTypeRepository showSeatTypeRepository,
                          PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.showSeatTypeRepository=showSeatTypeRepository;
        this.priceCalculatorService=priceCalculatorService;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, SeatNotEmptyException {

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User NOT found :(");
        }
        User bookedBy = userOptional.get();

        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new ShowNotFoundException("Show NOT Found :(");
        }
        Show bookedShow = showOptional.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)) {
                throw new SeatNotEmptyException("Not all selected seats are available");
            }
        }
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setShowSeats(showSeats);
        booking.setBookedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(bookedShow, showSeats));
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);
    }

}
