package org.dev.diptesh.cab_booking_application.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    private Long id;
    private Long userID;
    private Long drivingPartnerID;
    private Location sourceLocation;
    private Location destinationLocation;
}
