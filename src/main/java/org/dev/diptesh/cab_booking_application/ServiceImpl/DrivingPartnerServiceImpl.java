package org.dev.diptesh.cab_booking_application.ServiceImpl;

import org.dev.diptesh.cab_booking_application.Exceptions.DriverNotFoundException;
import org.dev.diptesh.cab_booking_application.Exceptions.UserNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.DrivingPartner;
import org.dev.diptesh.cab_booking_application.Models.Location;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.Models.Vehicle;
import org.dev.diptesh.cab_booking_application.Repositories.DrivingPartnerRepository;
import org.dev.diptesh.cab_booking_application.Services.DrivingPartnerService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.DrivingPartnerRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.DrivingPartnerResponseSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.VehicleResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrivingPartnerServiceImpl implements DrivingPartnerService {

    private Long id = 1L;
    private DrivingPartnerRepository drivingPartnerRepository;

    public DrivingPartnerServiceImpl(DrivingPartnerRepository drivingPartnerRepository) {
        this.drivingPartnerRepository = drivingPartnerRepository;
    }

    @Override
    public Long addDriver(DrivingPartnerRequestSignUpDto drivingPartnerRequestSignUpDto) {
        drivingPartnerRepository.save(id,drivingPartnerRequestSignUpDto);
        return id++;
    }

    @Override
    public DrivingPartnerResponseSignUpDto findDrivingPartnerByID(Long id) throws DriverNotFoundException {


        Optional<DrivingPartner> drivingPartnerOptional = drivingPartnerRepository.findDriver(id);
        //System.out.println(userOptional);
        if(drivingPartnerOptional.isEmpty()) {
            //System.out.println("HiQQ");
            throw new DriverNotFoundException("Driver Not Found");
        }

        DrivingPartnerResponseSignUpDto drivingPartnerResponseSignUpDto = new DrivingPartnerResponseSignUpDto();
        DrivingPartner drivingPartner = drivingPartnerOptional.get();
        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
        vehicleResponseDto.setId(drivingPartner.getVehicle().getId());
        vehicleResponseDto.setVehicleNumber(drivingPartner.getVehicle().getVehicleNumber());
        vehicleResponseDto.setVehicleType(drivingPartner.getVehicle().getVehicleType());
        Location location = new Location(drivingPartner.getLocation().getLatitude(),drivingPartner.getLocation().getLongitude());

        drivingPartnerResponseSignUpDto.setId(drivingPartner.getId());
        drivingPartnerResponseSignUpDto.setFirstName(drivingPartner.getFirstName());
        drivingPartnerResponseSignUpDto.setLastName(drivingPartner.getLastName());
        drivingPartnerResponseSignUpDto.setEmail(drivingPartner.getEmail());
        drivingPartnerResponseSignUpDto.setVehicle(vehicleResponseDto);
        drivingPartnerResponseSignUpDto.setLocation(location);
        return drivingPartnerResponseSignUpDto;
    }
}
