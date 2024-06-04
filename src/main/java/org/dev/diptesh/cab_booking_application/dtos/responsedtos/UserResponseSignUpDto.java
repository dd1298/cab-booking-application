package org.dev.diptesh.cab_booking_application.dtos.responsedtos;

import lombok.Getter;
import lombok.Setter;
import org.dev.diptesh.cab_booking_application.Enums.UserStatus;

@Getter
@Setter
public class UserResponseSignUpDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
