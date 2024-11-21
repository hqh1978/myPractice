package org.example.park;

public class Payment {
    private int paymentId;  //primary key
    private int userId;  //foreign key
    private int parkId; //foreign key
    private double amount;
    private int orderId; //foreign key
    private String status;


    /*
     * Get   /api/Payment
     *       /api/Payment/{paymentId}
     * Post  /api/Payment
     * */
}
