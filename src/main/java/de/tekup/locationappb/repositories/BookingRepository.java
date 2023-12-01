package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Booking;
import de.tekup.locationappb.entites.FlightDetails;
import de.tekup.locationappb.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
//    List<Booking>findByUserId(Long id);
List<Booking>findByUser_Username(String Id);

}
