package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
//    List<Booking>findByUserId(Long id);
}
