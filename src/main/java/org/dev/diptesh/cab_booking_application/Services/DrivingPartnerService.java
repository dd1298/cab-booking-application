package org.dev.diptesh.cab_booking_application.Services;

import org.dev.diptesh.cab_booking_application.Exceptions.BookingNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.Vehicle;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.DrivingPartnerRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DrivingPartnerService {
    Long addDriver(DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto);

    DrivingPartnerResponseSignUpDto findDrivingPartnerByID(Long id) throws DriverNotFoundException;
}
