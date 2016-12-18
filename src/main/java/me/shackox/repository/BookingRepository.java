package me.shackox.repository;

import me.shackox.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SHACKOX on 17/12/16.
 */

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {
    List<HotelBooking> findByPricePerNightLessThan(double price);
}
