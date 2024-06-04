package org.dev.diptesh.cab_booking_application.Models;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Enums.Availability;

@Getter
@Setter
public class DrivingPartner {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Vehicle vehicle;
    private Location location;
    //private Availability availability;
}
