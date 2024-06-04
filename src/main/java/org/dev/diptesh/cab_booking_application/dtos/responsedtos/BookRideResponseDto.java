package org.dev.diptesh.cab_booking_application.dtos.responsedtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;

@Getter
@Setter
public class BookRideResponseDto {
    private Long bookingId;
    private UserResponseSignUpDto user;
    private DrivingPartnerResponseSignUpDto drivingPartner;
    private Location sourceLocation;
    private Location destinationLocation;

}
