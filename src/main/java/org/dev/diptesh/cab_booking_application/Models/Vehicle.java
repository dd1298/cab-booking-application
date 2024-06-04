package org.dev.diptesh.cab_booking_application.Models;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Enums.VehicleType;

@Getter
@Setter
public class Vehicle {
    private long id;
    private VehicleType vehicleType;
    private String vehicleNumber;
}
