package org.dev.diptesh.cab_booking_application.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindRideRequestDto {
    private int sourceLat;
    private int sourceLong;
    private int destinationLat;
    private int destinationLong;
}
