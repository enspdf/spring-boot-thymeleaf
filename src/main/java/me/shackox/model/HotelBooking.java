package me.shackox.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by SHACKOX on 17/12/16.
 */
@Entity
@Data
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    private HotelBooking() {}

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public double getTotalPrice() {
        return pricePerNight * nbOfNights;
    }
}
