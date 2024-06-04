package org.dev.diptesh.cab_booking_application.Controllers;

import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Services.DrivingPartnerService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.DrivingPartnerRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DrivingPartnerController {
    private DrivingPartnerService drivingPartnerService;

    public DrivingPartnerController(DrivingPartnerService drivingPartnerService) {
        this.drivingPartnerService = drivingPartnerService;
    }

    @PostMapping("/drivingpartner")
    public ResponseEntity<String> addDriver(@RequestBody DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto) {
        Long driverId = drivingPartnerService.addDriver(drivingPartnerRequestSignUpDto);
        return new ResponseEntity<>("Added Driver Successfully with id "+driverId, HttpStatus.CREATED);
    }

    @GetMapping("/drivingpartner/{id}")
    public ResponseEntity<?> findByID(@PathVariable Long id) {
        try {
            DrivingPartnerResponseSignUpDto drivingPartnerResponseSignUpDto = drivingPartnerService.findDrivingPartnerByID(id);
            return new ResponseEntity<>(drivingPartnerResponseSignUpDto, HttpStatus.OK);
        }
        catch (DriverNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
