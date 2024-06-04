package org.dev.diptesh.cab_booking_application;

import org.dev.diptesh.cab_booking_application.Controllers.BookingController;
import org.dev.diptesh.cab_booking_application.Controllers.DrivingPartnerController;
import org.dev.diptesh.cab_booking_application.Controllers.UserController;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.Ride;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.FindRideRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CabBookingApplicationTests {

    @Test
    void contextLoads() {
    }


}
