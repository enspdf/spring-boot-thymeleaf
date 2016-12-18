package me.shackox.controller;

import me.shackox.model.HotelBooking;
import me.shackox.repository.BookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHACKOX on 17/12/16.
 */

@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Hotel Booking Api",
        description = "Methods to manage a hotel booking",
        stage = ApiStage.RC)
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotels from the database")
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all booking hotels where the price per night is less than the provided value")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a hotel booking and save it on database")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the hotel booking with the provided ID from the database")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id) {
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }
}
