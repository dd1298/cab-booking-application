package org.dev.diptesh.cab_booking_application.Repositories;


import org.dev.diptesh.cab_booking_application.Models.User;
import org.dev.diptesh.cab_booking_application.dtos.requestdtos.UserRequestSignUpDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private HashMap<Long,User> users = new HashMap<>();
    public Optional<User> findByID(Long userID) {
        return Optional.ofNullable(users.get(userID));
    }

    public void save(Long userId, UserRequestSignUpDto userRequestSignUpDto) {
        User user = new User();
        user.setId(userId);
        user.setFirstName(userRequestSignUpDto.getFirstName());
        user.setLastName(userRequestSignUpDto.getLastName());
        user.setEmail(userRequestSignUpDto.getEmail());
        users.put(userId,user);
    }
}
