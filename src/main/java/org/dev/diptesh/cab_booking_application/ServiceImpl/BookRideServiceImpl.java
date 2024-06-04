package org.dev.diptesh.cab_booking_application.ServiceImpl;

import org.dev.diptesh.cab_booking_application.Exceptions.BookingNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.Ride;
import org.dev.diptesh.cab_booking_application.Repositories.BookRideRepository;
import org.dev.diptesh.cab_booking_application.Repositories.DrivingPartnerRepository;
import org.dev.diptesh.cab_booking_application.Services.BookRideService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.BookRideRequestDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.BookRideResponseDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.awt.geom.Point2D.distance;

@Service
public class BookRideServiceImpl implements BookRideService {

    private Long bookingId = 1L;

    private DrivingPartnerRepository drivingPartnerRepository;
    private BookRideRepository bookRideRepository;


    public BookRideServiceImpl(DrivingPartnerRepository drivingPartnerRepository, BookRideRepository bookRideRepository) {
        this.drivingPartnerRepository = drivingPartnerRepository;
        this.bookRideRepository = bookRideRepository;
    }

    @Override
    public List<DrivingPartnerResponseSignUpDto> findRide(Location sourceLocation, Location destinationLocation) {
        List<DrivingPartnerResponseSignUpDto> drivers = drivingPartnerRepository.findAllDrivers();
        List<DrivingPartnerResponseSignUpDto> driversAvailable = new ArrayList<>();
        for(DrivingPartnerResponseSignUpDto drivingPartner : drivers) {
            if(distance(drivingPartner.getLocation().getLatitude(),drivingPartner.getLocation().getLongitude()
                    ,sourceLocation.getLatitude(),sourceLocation.getLongitude()) <= 5) {

                driversAvailable.add(drivingPartner);
            }
        }

        return driversAvailable;
    }


    @Override
    public void chooseRide(BookRideRequestDto ride) {
        bookRideRepository.save(bookingId++,ride);
    }

    @Override
    public BookRideResponseDto findBookingForUserId(Long userId) throws BookingNotFoundException, DriverNotFoundException {
        BookRideResponseDto bookRideResponseDto = bookRideRepository.findRideByUserId(bookingId,userId);
        if(bookRideResponseDto.getUser() == null) {
            throw new BookingNotFoundException("No Booking Found");
        }
        return bookRideResponseDto;
    }
}
