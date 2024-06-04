package org.dev.diptesh.cab_booking_application.Exceptions;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException(String vehicleNotFound) {
        super(vehicleNotFound);
    }
}
