package org.dev.diptesh.cab_booking_application.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Models.Location;

@Getter
@Setter
public class DrivingPartnerRequestSignUpDto {
    //private long id;
    private String firstName;
    private String lastName;
    private String email;
    private VehicleRequestDto vehicle;
    private Location location;
}
