package org.dev.diptesh.cab_booking_application;

import org.dev.diptesh.cab_booking_application.Controllers.DrivingPartnerController;
import org.dev.diptesh.cab_booking_application.Enums.VehicleType;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.DrivingPartnerRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.VehicleRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddDriverTestCase {

    @Autowired
    private DrivingPartnerController drivingPartnerController;

    @Test
    public void testAddDrivingPartner() {
        // Arrange
        DrivingPartnerRequestSignUpDto testDriver = new DrivingPartnerRequestSignUpDto();
        testDriver.setFirstName("Test");
        testDriver.setLastName("Driver");
        testDriver.setEmail("testdriver@example.com");
        VehicleRequestDto testVehicle = new VehicleRequestDto();
        testVehicle.setVehicleNumber("WB01AW1582");
        testVehicle.setVehicleType(VehicleType.FOUR_WHEELER);
        Location testLocation = new Location(0,0);
        testDriver.setVehicle(testVehicle);
        testDriver.setLocation(testLocation);
        // Act
        ResponseEntity<?> returnedDriver = drivingPartnerController.addDriver(testDriver);

        // Assert
        assertEquals(HttpStatus.CREATED, returnedDriver.getStatusCode());
//        assertTrue(returnedDriver.getBody().toString().contains("Driving Partner Added Successfully"));
    }
}