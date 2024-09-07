package com.example.ticketbookingconcurrent.Exceptions;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(String message){
        super(message);
    }
}
