package org.dev.diptesh.cab_booking_application.dtos.responsedtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.Vehicle;

@Getter
@Setter
public class DrivingPartnerResponseSignUpDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private VehicleResponseDto vehicle;
    private Location location;
}
