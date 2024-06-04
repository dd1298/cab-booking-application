package org.dev.diptesh.cab_booking_application.dtos.requestdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestSignUpDto {
    //private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
