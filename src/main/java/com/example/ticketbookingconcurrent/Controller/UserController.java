package com.example.ticketbookingconcurrent.Controller;

import com.example.ticketbookingconcurrent.Dtos.SignUpRequestDTO;
import com.example.ticketbookingconcurrent.Dtos.SignUpResponseDTO;
import com.example.ticketbookingconcurrent.Entity.User;
import com.example.ticketbookingconcurrent.Service.UserService;
import com.example.ticketbookingconcurrent.enums.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            User user = userService.signUp(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}

