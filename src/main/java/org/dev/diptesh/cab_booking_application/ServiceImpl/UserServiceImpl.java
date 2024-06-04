package org.dev.diptesh.cab_booking_application.ServiceImpl;


import org.dev.diptesh.cab_booking_application.Exceptions.UserNotFoundException;
import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.Repositories.UserRepository;
import org.dev.diptesh.cab_booking_application.Services.UserService;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.UserRequestSignUpDto;
import org.dev.diptesh.cab_booking_application.dtos.responsedtos.UserResponseSignUpDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Long id = 1L;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(UserRequestSignUpDto userRequestSignUpDto) {
        userRepository.save(id,userRequestSignUpDto);
        return  id++;
    }

    @Override
    public UserResponseSignUpDto findUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findByID(id);
        //System.out.println(userOptional);
        if(userOptional.isEmpty()) {
            //System.out.println("HiQQ");
            throw new UserNotFoundException("User Not Found");
        }
        UserResponseSignUpDto userResponseSignUpDto = new UserResponseSignUpDto();
        User user = userOptional.get();
        userResponseSignUpDto.setId(user.getId());
        userResponseSignUpDto.setFirstName(user.getFirstName());
        userResponseSignUpDto.setLastName(user.getLastName());
        userResponseSignUpDto.setEmail(user.getEmail());
        return userResponseSignUpDto;
    }
}
