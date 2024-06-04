package org.dev.diptesh.cab_booking_application.Repositories;

import org.dev.diptesh.cab_booking_application.Exceptions.BookingNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Ride;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.Services.DrivingPartnerService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.BookRideRequestDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.BookRideResponseDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRideRepository {

    List<Ride> rides = new ArrayList<>();

    private UserRepository userRepository;

    private DrivingPartnerService drivingPartnerService;

    @Autowired
    public BookRideRepository(UserRepository userRepository, DrivingPartnerService drivingPartnerService) {
        this.userRepository = userRepository;
        this.drivingPartnerService = drivingPartnerService;
    }
    public void save(Long id, BookRideRequestDto ride) {
        Ride newRide = new Ride();
        newRide.setId(id);
        newRide.setUserID(ride.getUserID());
        newRide.setDrivingPartnerID(ride.getDrivingPartnerID());
        newRide.setSourceLocation(ride.getSourceLocation());
        newRide.setDestinationLocation(ride.getDestinationLocation());
        rides.add(newRide);
    }



    public BookRideResponseDto findRideByUserId(Long bookingId, Long userId) throws DriverNotFoundException {
        BookRideResponseDto bookRideResponseDto = new BookRideResponseDto();
        for(Ride ride : rides) {
            if(ride.getUserID().equals(userId)) {

                bookRideResponseDto.setBookingId(bookingId);

                Optional<User> userOptional = userRepository.findByID(userId);
                User user = userOptional.get();

                UserResponseSignUpDto userResponseSignUpDto = new UserResponseSignUpDto();
                userResponseSignUpDto.setId(userId);
                userResponseSignUpDto.setFirstName(user.getFirstName());
                userResponseSignUpDto.setLastName(user.getLastName());
                userResponseSignUpDto.setEmail(user.getEmail());

                bookRideResponseDto.setUser(userResponseSignUpDto);

                DrivingPartnerResponseSignUpDto drivingPartner = drivingPartnerService.findDrivingPartnerByID(ride.getDrivingPartnerID());
                bookRideResponseDto.setDrivingPartner(drivingPartner);
                bookRideResponseDto.setSourceLocation(ride.getSourceLocation());
                bookRideResponseDto.setDestinationLocation(ride.getDestinationLocation());

                break;
            }
        }
        return bookRideResponseDto;
    }
}
