package org.dev.diptesh.cab_booking_application.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    //private Location location;
}
