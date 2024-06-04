package org.dev.diptesh.cab_booking_application.Services;

import org.dev.diptesh.cab_booking_application.Exceptions.BookingNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.Ride;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.BookRideRequestDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.BookRideResponseDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;

import java.util.List;

public interface BookRideService {
    List<DrivingPartnerResponseSignUpDto> findRide(Location sourceLocation, Location destinationLocation);

    void chooseRide(BookRideRequestDto ride);

    BookRideResponseDto findBookingForUserId(Long userId) throws BookingNotFoundException, DriverNotFoundException;
}
