package org.dev.diptesh.cab_booking_application.Repositories;

import org.apache.catalina.User;
import org.dev.diptesh.cab_booking_application.Models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicles = new HashMap<>();

    public List<Optional<Vehicle>> findByID(List<Long> vehicleID) {
        List<Optional<Vehicle>> vehiclesOptional = new ArrayList<>();
        for(Long id : vehicleID) {
            vehiclesOptional.add(Optional.of(vehicles.get(id)));
        }
        return  vehiclesOptional;
    }
}
