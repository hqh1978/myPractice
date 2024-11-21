package org.example.park;

import java.util.Date;
//停车位
public class ParkingSpace {
    private String parkId;  //PRIMARY KEY AUTO_INCREMENT,
    private boolean occupied;
    private Date start;
    private Date end;
    private String lotId;  //foreign key

    /*
     * Get   /api/parkingSpace
     *       /api/parkingSpace/{parkId}
     * Post  /api/parkingSpace
     * Put   /api/parkingSpace/{parkId}
     * Del   /api/parkingSpace/{parkId}
     * */

}