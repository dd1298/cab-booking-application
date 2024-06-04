package org.dev.diptesh.cab_booking_application.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Location {
    //private long id;
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
