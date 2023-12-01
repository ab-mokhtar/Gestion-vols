package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.repositories.BookingRepository;
import de.tekup.locationappb.repositories.FlightDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private  final BookingRepository bookingRepository;
    private final FlightDetailsRepository flightDetailsRepository;

    public List<Booking>getAll(){
        return bookingRepository.findAll();
    }

    public void delete(long id){
        Booking b=bookingRepository.findById(id).orElseThrow();
        FlightDetails fly=b.getFlightDetails();
        fly.setResrvedeconomyClassSeats(-b.getEconomyClassTickets());
        fly.setResrvedbusinessClassSeats(-b.getBusinessClassTickets());
        fly.setResrvedfirstClassSeats(-b.getFirstClassTickets());
        flightDetailsRepository.save(fly);
        bookingRepository.deleteById(id);
    }
    public Booking getById(Long id){
        return bookingRepository.findById(id).orElseThrow();
    }
    public Booking add(Booking booking){
        return bookingRepository.save(booking);
    }
    public Booking update(Booking booking){return bookingRepository.save(booking);}
    public List<Booking>getByUserId(String id){return bookingRepository.findByUser_Username(id);}
}
