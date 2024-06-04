package org.dev.diptesh.cab_booking_application.Controllers;

import org.dev.diptesh.cab_booking_application.Exceptions.UserNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.Services.UserService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.UserRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //add_user(user_detail)
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserRequestSignUpDto userRequestSignUpDto) {
        Long userId = userService.addUser(userRequestSignUpDto);
        return new ResponseEntity<>("User Added Successfully with id "+userId, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserResponseSignUpDto user = userService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
