package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Long> {
    List<FlightDetails>findByOriginAndDestinationAndDepartureDateIsBetween(String origin, String destination, LocalDate d1,LocalDate d2);
}
