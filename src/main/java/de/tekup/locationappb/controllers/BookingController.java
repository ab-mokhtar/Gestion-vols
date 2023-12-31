package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.services.BookingService;
import de.tekup.locationappb.services.FlightDetailsService;
import de.tekup.locationappb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final FlightDetailsService flightDetailsService;
    private final UserService userService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getById(id);
    }

    @GetMapping("/user/{id}")
    public List<Booking> getBookingByUserId(@PathVariable String id) {
        return bookingService.getByUserId(id);
    }



    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        FlightDetails fly=flightDetailsService.findById(booking.getFlightDetails().getId());
        booking.setDate(LocalDate.now());
        booking.setFlightDetails(fly);
        booking.setUser(userService.getUserById(booking.getUser().getUsername()));
        Booking b=bookingService.add(booking);
        fly.setResrvedeconomyClassSeats(booking.getEconomyClassTickets());
        fly.setResrvedbusinessClassSeats(booking.getBusinessClassTickets());
        fly.setResrvedfirstClassSeats(booking.getFirstClassTickets());
        flightDetailsService.addFlight(fly);
        return b;
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@RequestBody Booking booking){
        Booking booking1 = bookingService.update(booking);
        return new ResponseEntity<>(booking1, HttpStatus.OK);
    }
}
