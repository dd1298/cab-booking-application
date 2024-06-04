package org.dev.diptesh.cab_booking_application.Controllers;


import org.dev.diptesh.cab_booking_application.Exceptions.BookingNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.*;
import org.dev.diptesh.cab_booking_application.Services.BookRideService;
import org.dev.diptesh.cab_booking_application.Services.UserService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.BookRideRequestDto;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.FindRideRequestDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.BookRideResponseDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private UserService userService;
    private BookRideService bookRideService;

    public BookingController(UserService userService, BookRideService bookRideService) {
        this.userService = userService;
        this.bookRideService = bookRideService;
    }

    @GetMapping("/findRide")
    public ResponseEntity<?> findRide(@RequestParam int sourceLat,
                                      @RequestParam int sourceLong,
                                      @RequestParam int destinationLat,
                                      @RequestParam int destinationLong) {


        Location sourceLocation = new Location(sourceLat, sourceLong);
        Location destinationLocation = new Location(destinationLat, destinationLong);
        try {
            List<DrivingPartnerResponseSignUpDto> driversAvailable = bookRideService.findRide(sourceLocation, destinationLocation);
            if (driversAvailable.isEmpty()) {
                throw new DriverNotFoundException("Drivers Not Found");
            }
            return new ResponseEntity<>(driversAvailable, HttpStatus.OK);
        } catch (DriverNotFoundException driverNotFoundException) {
            return new ResponseEntity<>(driverNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ride")
    public ResponseEntity<String> chooseRide(@RequestBody BookRideRequestDto ride) {
        bookRideService.chooseRide(ride);
        return new ResponseEntity<>("Driver ID "+ride.getDrivingPartnerID(),HttpStatus.OK);
    }

    @GetMapping("/ride/{userId}")
    ResponseEntity<?> findRideForUserId(@PathVariable Long userId) {
        try {
            BookRideResponseDto bookRide = bookRideService.findBookingForUserId(userId);
            return new ResponseEntity<>(bookRide, HttpStatus.OK);
        }
        catch (BookingNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch (DriverNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

