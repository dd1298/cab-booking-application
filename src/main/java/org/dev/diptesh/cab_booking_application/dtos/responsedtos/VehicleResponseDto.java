package org.dev.diptesh.cab_booking_application.dtos.responsedtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Enums.VehicleType;

@Getter
@Setter
public class VehicleResponseDto {
    private Long id;
    private VehicleType vehicleType;
    private String vehicleNumber;
}
