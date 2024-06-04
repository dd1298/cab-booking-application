package org.dev.diptesh.cab_booking_application.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Enums.VehicleType;

@Getter
@Setter
public class VehicleRequestDto {
    private VehicleType vehicleType;
    private String vehicleNumber;
}
