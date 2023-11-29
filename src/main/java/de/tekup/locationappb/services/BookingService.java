package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private  final BookingRepository bookingRepository;

    public List<Booking>getAll(){
        return bookingRepository.findAll();
    }

    public void delete(long id){
        bookingRepository.deleteById(id);
    }
    public Booking getById(Long id){
        return bookingRepository.findById(id).orElseThrow();
    }
    public Booking add(Booking booking){
        return bookingRepository.save(booking);
    }
    public Booking update(Booking booking){return bookingRepository.save(booking);}
}
