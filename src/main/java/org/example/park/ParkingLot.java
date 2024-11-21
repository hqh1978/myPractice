package org.example.park;

//停车场
public class ParkingLot {
    private String lotId;  //PRIMARY KEY AUTO_INCREMENT,
    private String name;
    private String location;
    private int capacity;
    public ParkingLot(String lotId,String name,String location,int capacity){
        this.lotId=lotId;
        this.name=name;
        this.location=location;
        this.capacity=capacity;
    }
    /*
    *
    * Get   /api/parkinglots
    *       /api/parkinglots/{lotId}
    * Post  /api/parkinglots
    * Put   /api/parkinglots/{lotId}
    * Del   /api/parkinglots/{lotId}
    * */
}
