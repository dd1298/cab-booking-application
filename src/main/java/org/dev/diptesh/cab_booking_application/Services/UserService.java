package org.dev.diptesh.cab_booking_application.Services;

import org.dev.diptesh.cab_booking_application.Exceptions.UserNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.UserRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Long addUser(UserRequestSignUpDto userRequestSignUpDto);

    UserResponseSignUpDto findUserById(Long id) throws UserNotFoundException;
}
