package org.example.park;

import java.util.Date;

public class Order {
    private int orderId;  //primary key
    private int userId;  //foreign key
    private int parkId;  //foreign key
    private Date start;
    private Date end;
    private String status;
    /*
     * Get   /api/order
     *       /api/order/{orderId}
     * Post  /api/order

     * Del   /api/orderId
     * */
}
