package com.example.ticketbookingconcurrent.Exceptions;

public class SeatNotEmptyException extends Exception{

    public SeatNotEmptyException(String message){
        super(message);
    }
}
