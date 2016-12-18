package me.shackox.seeder;

import me.shackox.model.HotelBooking;
import me.shackox.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHACKOX on 17/12/16.
 */

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Hotel 1", 100, 1));
        bookings.add(new HotelBooking("Hotel 2", 200, 2));
        bookings.add(new HotelBooking("Hotel 3", 300, 3));

        bookingRepository.save(bookings);
    }
}
