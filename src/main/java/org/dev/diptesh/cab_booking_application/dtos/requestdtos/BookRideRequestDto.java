package org.dev.diptesh.cab_booking_application.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Models.Location;

@Getter
@Setter
public class BookRideRequestDto {
    private Long userID;
    private Long drivingPartnerID;
    private Location sourceLocation;
    private Location destinationLocation;
}
